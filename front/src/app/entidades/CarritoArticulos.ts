import { Articulo } from "./articulos";
import { Carrito } from "./carrito";

export class CarritoArticulos {
    public idCarritoArticulos:number;
    public carrito:Carrito;
    public articulo:Articulo;
    public fechaAgregadoCarrito:Date;
    public cantidad:number;
    public subTotal:number;

    constructor() {
        this.idCarritoArticulos = 0;
        this.carrito = new Carrito();
        this.articulo = new Articulo();
        this.fechaAgregadoCarrito = new Date();
        this.cantidad = 0;
        this.subTotal = 0;
    }
}