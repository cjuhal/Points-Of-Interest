package ar.edu.unsam.poiapp.adapter;

import android.view.View;
import android.widget.TextView;

import ar.edu.unsam.poiapp.R;
import ar.edu.unsam.poiapp.domain.Poi;

/**
 * Created by Cristian on 15/11/2016.
 */

public class LocalComercialAdapter {
    public View getView(View rootView, Poi poi) {

        ((TextView) rootView.findViewById(R.id.direccion)).setText("Dirección: \n" + poi.getDireccion()  + "\n");
        ((TextView) rootView.findViewById(R.id.rubroNombre)).setText("Rubro: \n" + poi.getNombreRubro() + "\n");
        ((TextView) rootView.findViewById(R.id.rubroCercania)).setText("Distancia del local: \n" + poi.getCercaniaRubro() + "km \n");
        ((TextView) rootView.findViewById(R.id.horario)).setText("Horario: \nApertura: " + poi.getHorarioInicio() + "\nClausura:" + poi.getHorarioFin() + "\n");

        ((TextView) rootView.findViewById(R.id.calificacionGeneral)).setText("Calificación General: " + poi.getCalificacion() + "\n" );
        ((TextView) rootView.findViewById(R.id.calificacion)).setText("Review: \n" + poi.getReviews());

        return rootView;
    }
}
