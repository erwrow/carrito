/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.carrito.services;

import com.example.carrito.Entidades.Carrito;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erwrow
 * 
 * ToDo:
 * Faltaría agregar el repo del carrito.
 */

@Service
public class CarritoService {
    /**
     * Acá se guarda/actualiza el carrito, así como calcular los "montos"
     * correctos, por si, desde el front, se modifica algún dato. Se recupera la
     * info de la bd y en base a eso se trabaja.
     */
    public Carrito guardarCarrito(Carrito carritoRecibido) throws Exception {
        
        Carrito carritoGuardado = new Carrito();
        
        
        return carritoGuardado;
    }
}
