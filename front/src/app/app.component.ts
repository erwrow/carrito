import { Component, OnInit } from '@angular/core';
import { Config } from './config/config';
import { CarritoService } from './services/carrito.service';
import { Articulo } from './entidades/articulos';
import { Carrito } from './entidades/carrito';
import { ArticulosService } from './services/articulos.service';
import { CarritoArticulos } from './entidades/CarritoArticulos';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
	title = 'carrito';

	public articulos: Articulo[] = [];

	public carrito: Carrito = new Carrito();

	public total: number = 0;

	constructor(private as: ArticulosService, private cs: CarritoService) {

	}

	/**
	 * Obtengo los artículos en el inicio
	 */
	ngOnInit(): void {
		this.as.obtenerArticulos().subscribe(
			data => {
				console.log(data);
				this.articulos = data;
			}, e => {
				console.error(e);
			}
		)
	}

	/**
	 * Se agrega el ítem al carrito o se incrementa en 1 la cantidad
	 */
	agregarItemCarrito(e:Articulo) {
		if(Config.verbose) console.log(e);
		
		const i = this.carrito.CarritoArticulos.map(f => f.articulo.idArticulo).indexOf(e.idArticulo);
		
		if(i > -1) {
			this.carrito.CarritoArticulos[i].cantidad++;
			this.carrito.CarritoArticulos[i].subTotal = this.carrito.CarritoArticulos[i].articulo.monto * this.carrito.CarritoArticulos[i].cantidad;

		} else {
			let nuevoItemCarrito = new CarritoArticulos();

			nuevoItemCarrito.articulo = e;
			nuevoItemCarrito.cantidad = 1;
			nuevoItemCarrito.articulo.monto = e.monto;
			nuevoItemCarrito.subTotal = e.monto * nuevoItemCarrito.cantidad;

			this.carrito.CarritoArticulos.push(nuevoItemCarrito);
		}
		
		this.calcularTotal();
	}

	/**
	 * Método para sacar el artículo del carrito
	 */
	removerItemCarrito(e:CarritoArticulos) {
		if(Config.verbose) console.log({e, carrito:this.carrito});

		const i = this.carrito.CarritoArticulos.map(f => f.articulo.idArticulo).indexOf(e.articulo.idArticulo);
		
		if(i > -1) {
			this.carrito.CarritoArticulos.splice(i, 1);
		} else {
			console.error("El item no se encuentra en el carrito");
		}

		this.calcularTotal();
	}

	/**
	 * Esto se va a calcular en la api.
	 */
	calcularTotal() {
		this.total = 0;

		/**
		 * Calculo de forma provisional el total de la compra
		 * Esto se puede eliminar si no se desea tener un pre-
		 * cálculo del total.
		 */
		this.carrito.CarritoArticulos.forEach((articulo) => {
			this.total += articulo.subTotal;
		});

		/**
		 * Se envía el carrito a la api para que me devuelva los
		 * montos calculados y en base a los datos de la bd
		 */
		this.cs.guardarCarrito(this.carrito).subscribe(
			data => {
				this.carrito = data;

				this.total = 0;
				/**
				 * Ahora que la api me confirmó el carrito, puedo
				 * mostrar el verdadero total
				 */
				this.carrito.CarritoArticulos.forEach((articulo) => {
					this.total += articulo.subTotal; 
				});
			}, e => {
				console.error(e);
			}
		)
	}
}
