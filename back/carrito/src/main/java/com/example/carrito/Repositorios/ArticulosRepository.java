/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.carrito.Repositorios;

import com.example.carrito.Entidades.Articulos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erwrow
 */
@Repository
public interface ArticulosRepository extends JpaRepository<Articulos, Integer> {
    @Query ("SELECT a FROM Articulos a WHERE a.habilitado = 1")
    public List<Articulos> obtenerArticulosHabilitados();
}
