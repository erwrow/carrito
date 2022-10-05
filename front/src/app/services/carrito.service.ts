import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Config } from '../config/config';
import { Carrito } from '../entidades/carrito';

@Injectable({
	providedIn: 'root'
})
export class CarritoService {

	private apiUrl: string;

	constructor(private http: HttpClient) {
		this.apiUrl = Config.apiUrl;
	}

	/**
	 * Guardo/actualizo el carrito contra la api y me devuelve con los montos correctos
	 * obtenidos de la bd.
	 */
	public guardarCarrito(carrito:Carrito) {
		console.log(carrito);

		let params = new HttpParams().append('carrito', JSON.stringify(carrito));

		const options = {
			params
		};

		return this.http.get<Carrito>(this.apiUrl + '/guardarCarrito', options);
	}
}
