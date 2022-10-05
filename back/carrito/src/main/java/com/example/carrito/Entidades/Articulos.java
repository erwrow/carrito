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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Erwrow
 */
@Entity
@Table(name = "articulos")
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a"),
    @NamedQuery(name = "Articulos.findAllHabilitado", query = "SELECT a FROM Articulos a WHERE a.habilitado = 1"),
    @NamedQuery(name = "Articulos.findByIdArticulo", query = "SELECT a FROM Articulos a WHERE a.idArticulo = :idArticulo")
})
public class Articulos {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idArticulo")
    private Integer idArticulo;
    @Column(name = "fechaCreacionArticulo", columnDefinition = "datetime NOT NULL DEFAULT current_timestamp()")
    private Date fechaCreacionArticulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "monto")
    private Float monto;
    @Column(name = "habilitado", columnDefinition="int DEFAULT 1")
    private Integer habilitado;

    public Articulos() {
    }

    public Articulos(Integer idArticulo, Date fechaCreacionArticulo, String descripcion, Float monto, Integer habilitado) {
        this.idArticulo = idArticulo;
        this.fechaCreacionArticulo = fechaCreacionArticulo;
        this.descripcion = descripcion;
        this.monto = monto;
        this.habilitado = habilitado;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Date getFechaCreacionArticulo() {
        return fechaCreacionArticulo;
    }

    public void setFechaCreacionArticulo(Date fechaCreacionArticulo) {
        this.fechaCreacionArticulo = fechaCreacionArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Integer getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Integer habilitado) {
        this.habilitado = habilitado;
    }
    
    
}
