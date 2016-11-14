package ar.edu.unsam.poiapp.domain;

import java.io.Serializable;

/**
 * Created by JD on 07/11/2016.
 */

public class Poi implements Serializable{

    Long id;

    String nombre;
    String direccion;
    String tipo;

    public Poi(String nombre, String direccion, String tipo) {
//        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
    }
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        if (direccion == null) {
            return "(sin dirección)";}
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String toString() {
        return nombre;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
