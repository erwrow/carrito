import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Articulo } from 'src/app/entidades/articulos';

@Component({
	selector: 'app-tarjeta-item',
	templateUrl: './tarjeta-item.component.html',
	styleUrls: ['./tarjeta-item.component.css']
})
export class TarjetaItemComponent implements OnInit {

	/**
	 * Datos del artículo
	 */
	@Input() articulo:Articulo = new Articulo();

	@Output() output = new EventEmitter<any>();

	constructor() { }

	ngOnInit(): void {
	}

	/**
	 * Método para avisarle al elemento padre que se agrega el ítem al carrito
	 */
	enviarItem() {
		this.output.emit(this.articulo);
	}

}
