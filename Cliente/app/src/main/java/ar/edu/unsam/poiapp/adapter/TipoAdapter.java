package ar.edu.unsam.poiapp.adapter;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unsam.poiapp.R;
import ar.edu.unsam.poiapp.domain.Poi;

/**
 * Created by Cristian on 14/11/2016.
 */

public class TipoAdapter {
    static Map<String, Integer> mapaTipo;

    private Map<String, Integer> getMapaTipo() {
        if (mapaTipo == null) {
            mapaTipo = new HashMap<String, Integer>();
            mapaTipo.put("Colectivo", R.drawable.colectivo);
            mapaTipo.put("Cgp", R.drawable.cgp);
            mapaTipo.put("Banco", R.drawable.banco);
            mapaTipo.put("LocalComercial", R.drawable.localcomercial);

        }
        return mapaTipo;
    }

    public int getImgTipo(Poi poi) {
        Integer result = getMapaTipo().get(poi.getTipo());
        if (result == null) {
            return R.drawable.error;
        }
        return result.intValue();
    }

}
