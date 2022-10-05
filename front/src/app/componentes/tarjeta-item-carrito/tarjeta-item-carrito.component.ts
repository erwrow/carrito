import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CarritoArticulos } from 'src/app/entidades/CarritoArticulos';

@Component({
  selector: 'app-tarjeta-item-carrito',
  templateUrl: './tarjeta-item-carrito.component.html',
  styleUrls: ['./tarjeta-item-carrito.component.css']
})
export class TarjetaItemCarritoComponent implements OnInit {

	/**
	 * Datos del artículo en el carrito
	 */
	@Input() carritoData:CarritoArticulos = new CarritoArticulos();

	@Output() output = new EventEmitter<any>();

	constructor() { }

	ngOnInit(): void {
	}

	/**
	 * Si se desea remover el artículo del carrito se le avisa al componente padre
	 */
	sacarItem() {
		this.output.emit(this.carritoData);
	}
}
