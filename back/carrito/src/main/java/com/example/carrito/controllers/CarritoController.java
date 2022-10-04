/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.carrito.controllers;

import com.example.carrito.services.CarritoService;
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
public class CarritoController {
    
    @Autowired
    private CarritoService cs;
    
    /**
     * Acá recibo el carrito
     */
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/guardarCarrito")
    public ResponseEntity<?> guardarCarrito(@RequestParam(value = "carrito", defaultValue = "") String data) throws Exception {
        try {
            System.out.println(data);
            return ResponseEntity.ok(this.cs.guardarCarrito());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar el carrito: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
