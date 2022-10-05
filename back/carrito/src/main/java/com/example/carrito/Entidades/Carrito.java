/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.carrito.Entidades;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Erwrow
 */
@Entity
@Table(name = "carrito")
@NamedQueries({
    @NamedQuery(name = "Carrito.findAll", query = "SELECT c FROM Carrito c"),
    @NamedQuery(name = "Carrito.findAllHabilitado", query = "SELECT c FROM Carrito c WHERE c.habilitado = 1"),
    @NamedQuery(name = "Carrito.findByIdCarrito", query = "SELECT c FROM Carrito c WHERE c.idCarrito = :idCarrito"),
    @NamedQuery(name = "Carrito.findByIdUsuario", query = "SELECT c FROM Carrito c WHERE c.usuario.idUsuario = :idUsuario")
})
public class Carrito {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCarrito")
    private Integer idCarrito;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarritoArticulos", fetch = FetchType.LAZY)
    private List<CarritoArticulos> CarritoArticulos;
    @Column(name = "fechaCreacionCarrito", columnDefinition = "datetime NOT NULL DEFAULT current_timestamp()")
    private Date fechaCreacionCarrito;
    @Column(name = "fechaFinalizacionCompra")
    private Date fechaFinalizacionCompra;
    @Column(name = "total")
    private Float total;
    @Column(name = "habilitado", columnDefinition="int DEFAULT 1")
    private Integer habilitado;

    public Carrito() {
    }

    public Carrito(Integer idArticulo, Usuarios usuario, Date fechaCreacionCarrito, Date fechaFinalizacionCompra, Float total, Integer habilitado) {
        this.idCarrito = idArticulo;
        this.usuario = usuario;
        this.fechaCreacionCarrito = fechaCreacionCarrito;
        this.fechaFinalizacionCompra = fechaFinalizacionCompra;
        this.total = total;
        this.habilitado = habilitado;
    }

    public Integer getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCreacionArticulo() {
        return fechaCreacionCarrito;
    }

    public void setFechaCreacionArticulo(Date fechaCreacionCarrito) {
        this.fechaCreacionCarrito = fechaCreacionCarrito;
    }

    public Date getFechaFinalizacionCompra() {
        return fechaFinalizacionCompra;
    }

    public void setFechaFinalizacionCompra(Date fechaFinalizacionCompra) {
        this.fechaFinalizacionCompra = fechaFinalizacionCompra;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Integer habilitado) {
        this.habilitado = habilitado;
    }
    
    
}
