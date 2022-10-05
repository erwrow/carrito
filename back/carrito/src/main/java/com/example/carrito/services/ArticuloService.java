/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.carrito.services;

import com.example.carrito.Entidades.Articulos;
import com.example.carrito.Repositorios.ArticulosRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erwrow
 */

@Service
public class ArticuloService {
    
    @Autowired
    private ArticulosRepository ar;
    
    @Transactional
    public List<Articulos> obtenerArticulos() throws Exception {
        
        List<Articulos> articulos = new ArrayList<Articulos>();
        
        articulos = ar.obtenerArticulosHabilitados();
        
        return articulos;
    }
}
