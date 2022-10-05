/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.carrito.controllers;

import com.example.carrito.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Erwrow
 */

@RestController
public class ArticulosController {
    
    @Autowired
    private ArticuloService as;
    
    /**
     * Consulto los articulos de la bd
     */
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/obtenerArticulos")
    public ResponseEntity<?> obtenerArticulos() throws Exception {
        try {
            return ResponseEntity.ok(this.as.obtenerArticulos());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener los articulos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
