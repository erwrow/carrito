/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.carrito.Entidades;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Erwrow
 */
@Entity
@Table(name = "carritoArticulos")
@NamedQueries({
    @NamedQuery(name = "CarritoArticulos.findAll", query = "SELECT ca FROM CarritoArticulos ca"),
    @NamedQuery(name = "CarritoArticulos.findByIdCarrito", query = "SELECT ca FROM CarritoArticulos ca WHERE ca.carrito.idCarrito = :idCarrito"),
    @NamedQuery(name = "CarritoArticulos.findByIdUsuario", query = "SELECT ca FROM CarritoArticulos ca WHERE ca.articulo.idArticulo = :idArticulo")
})
public class CarritoArticulos {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCarritoArticulos")
    private Integer idCarritoArticulos;
    @JoinColumn(name = "idCarrito")
    @ManyToOne
    private Carrito carrito;
    @JoinColumn(name = "idArticulo")
    @ManyToOne
    private Articulos articulo;
    @Column(name = "fechaAgregadoCarrito", columnDefinition = "datetime NOT NULL DEFAULT current_timestamp()")
    private Date fechaAgregadoCarrito;
    @Column(name = "cantidad")
    private Float cantidad;
    @Column(name = "subTotal")
    private Float subTotal;

    public CarritoArticulos() {
    }

    public CarritoArticulos(Integer idCarritoArticulos, Carrito idCarrito, Articulos idArticulo, Date fechaAgregadoCarrito, Float cantidad, Float subTotal) {
        this.idCarritoArticulos = idCarritoArticulos;
        this.carrito = idCarrito;
        this.articulo = idArticulo;
        this.fechaAgregadoCarrito = fechaAgregadoCarrito;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Integer getIdCarritoArticulos() {
        return idCarritoArticulos;
    }

    public void setIdCarritoArticulos(Integer idCarritoArticulos) {
        this.idCarritoArticulos = idCarritoArticulos;
    }

    public Carrito getIdCarrito() {
        return carrito;
    }

    public void setIdCarrito(Carrito idCarrito) {
        this.carrito = idCarrito;
    }

    public Articulos getIdArticulo() {
        return articulo;
    }

    public void setIdArticulo(Articulos idArticulo) {
        this.articulo = idArticulo;
    }

    public Date getFechaAgregadoCarrito() {
        return fechaAgregadoCarrito;
    }

    public void setFechaAgregadoCarrito(Date fechaAgregadoCarrito) {
        this.fechaAgregadoCarrito = fechaAgregadoCarrito;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }
    
    
}
