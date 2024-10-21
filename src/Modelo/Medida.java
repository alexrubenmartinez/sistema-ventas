/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author lexss
 */
public class Medida {
    private int id;
    private String nombre;
    private String nombre_corto;

    public Medida() {
    }

    public Medida(int id, String nombre, String nombre_corto) {
        this.id = id;
        this.nombre = nombre;
        this.nombre_corto = nombre_corto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_corto() {
        return nombre_corto;
    }

    public void setNombre_corto(String nombre_corto) {
        this.nombre_corto = nombre_corto;
    }
    
    
}
