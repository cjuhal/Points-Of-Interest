package ar.edu.unsam.poiapp.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by JD on 07/11/2016.
 */

public class Poi implements Serializable{

    Long id;
    String nombre;
    String direccion;
    String tipo;

    public String getCalificacion() {
        return calificacion.getPromedioCalificacion();
    }
    public String getReviews() {
        return calificacion.getReviews();
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    Calificacion calificacion;


    public Poi(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        if (direccion == null) {
            return "(sin dirección)";
        }
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String toString() {
        return nombre;
    }
}
