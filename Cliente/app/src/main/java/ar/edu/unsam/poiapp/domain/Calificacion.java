package ar.edu.unsam.poiapp.domain;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Cristian on 15/11/2016.
 */

public class Calificacion implements Serializable {
    public String promedioCalificacion;
    public List<Review> listaReview;

    public String getPromedioCalificacion() {
        return promedioCalificacion;
    }

    public void setPromedioCalificacion(String promedioCalificacion) {
        this.promedioCalificacion = promedioCalificacion;
    }

    public String getReviews() {
        String mensajes = "";
        for (Review item : listaReview) {
            mensajes += "\nUsuario: " + item.getNombreDeUsuario() + "\n Comentario: " + item.getComentario() + "\n Puntuacion: " + item.getPuntuacion() + "\n";
        }
        return mensajes;
    }
}