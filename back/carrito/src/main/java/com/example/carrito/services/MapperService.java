/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.carrito.services;

import com.example.carrito.Entidades.Carrito;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erwrow
 * Service para el mapeo de entidades
 * Faltan los mapeadores de JSON a usuario, articulos y carritoArtículos.
 */

@Service
public class MapperService {
    
    public Carrito JSONACarrito(JSONObject eJSON) {
        Carrito c = new Carrito();
        
        try {
            String tmp = getObjetcValue(eJSON, "idCarrito");
            if(!tmp.isEmpty()) {
                c.setIdCarrito(Integer.parseInt(tmp));
            }
        } catch (Exception e) {
            System.out.println("Excepción al mapear mapper.JSONACarrito.idCarrito");
        }
        try {
            String tmp = getObjetcValue(eJSON, "total");
            if(!tmp.isEmpty()) {
                c.setTotal(Float.parseFloat(tmp));
            }
        } catch (Exception e) {
            System.out.println("Excepción al mapear mapper.JSONACarrito.total");
        }
        try {
            JSONObject tmp = getObjetcValueJSON(eJSON, "usuario");
            if(!tmp.isEmpty()) {
                //c.setUsuario(JSONAUsuario(tmp));
            }
        } catch (Exception e) {
            System.out.println("Excepción al mapear mapper.JSONACarrito.usuario");
        }
        
        return c;
    }
    
    public String getObjetcValue(JSONObject obj, String key) {
        if (obj.containsKey(key)) {
            if (obj.get(key) != null) {
                return obj.get(key).toString();
            }
        }
        return "";
    }
    
    private JSONObject getObjetcValueJSON(JSONObject obj, String key) {
        if (obj.containsKey(key)) {
            if (obj.get(key) != null) {
                return (JSONObject) obj.get(key);
            }
        }
        return null;
    }
    
    public JSONObject StringAJSON(String data) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(data);
            
            return obj;
        } catch (Exception e) {
            System.out.println("Excepción al tratar de convertir de String a JSON");
        }
        return null;
    }
}
