package ar.edu.unsam.poiapp.adapter;

import android.view.View;
import android.widget.TextView;

import ar.edu.unsam.poiapp.R;
import ar.edu.unsam.poiapp.domain.Poi;

/**
 * Created by Cristian on 15/11/2016.
 */

public class CgpAdapter {
    public View getView(View rootView, Poi poi) {

        ((TextView) rootView.findViewById(R.id.direccion)).setText("Dirección: \n" + poi.getDireccion());
        ((TextView) rootView.findViewById(R.id.servicio)).setText("666: \n" + poi.getDireccion());

        return rootView;
    }
}
