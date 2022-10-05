package com.example.carrito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarritoApplication {
    
    /**
     * Faltan agregar (o agregar funcionalidades en):
     * articulos (controller, service)
     * carrito (controller, service, repo)
     * CarritoArticulos (controller, service, repo)
     * Usuarios (controller, service, repo)
     * 
     * Además habría que agregar un manejo básico de usuarios.
     */
    public static void main(String[] args) {
        SpringApplication.run(CarritoApplication.class, args);
    }

}
/**
 * Fórmula para calcular el tiempo de exposición de una foto, en base al ISO y 
 * la F.
 * 
 * tExp = 100 / ISO * F^2 / 16^2 * 0,01s
 */