import { CarritoArticulos } from "./CarritoArticulos";

export class Carrito {
    public idCarrito:number;
    public fechaCreacionCarrito:Date;
    public total:number;
    public CarritoArticulos:CarritoArticulos[];

    constructor() {
        this.idCarrito = 0;
        this.fechaCreacionCarrito = new Date();
        this.total = 0;
        this.CarritoArticulos = [];
    }
}