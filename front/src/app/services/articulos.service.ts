import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Config } from '../config/config';
import { Articulo } from '../entidades/articulos';

@Injectable({
	providedIn: 'root'
})
export class ArticulosService {

	private apiUrl: string;

	constructor(private http: HttpClient) {
		this.apiUrl = Config.apiUrl;
	}

	/**
	 * Obtengo el listado de artículos
	 */
	public obtenerArticulos() {
		return this.http.get<Articulo[]>(this.apiUrl + '/obtenerArticulos', {});
	}
}
