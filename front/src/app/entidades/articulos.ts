export class Articulo {
    public idArticulo:number;
    public imagen:any;
    public descripcion:string;
    public fechaCreacionArticulo:Date;
    public monto:number;

    constructor() {
        this.idArticulo = 0;
        this.imagen = null;
        this.descripcion = "";
        this.fechaCreacionArticulo = new Date();
        this.monto = 0;
    }
}