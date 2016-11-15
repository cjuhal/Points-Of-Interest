package ar.edu.unsam.poiapp.adapter;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unsam.poiapp.R;
import ar.edu.unsam.poiapp.domain.Poi;

/**
 * Created by Cristian on 14/11/2016.
 */

public class TipoAdapter {
    static Map<String, Integer> mapaTipoImg;
    static Map<String, Integer> mapaTipoLayout;

    private Map<String, Integer> getMapaTipoImg() {
        if (mapaTipoImg == null) {
            mapaTipoImg = new HashMap<String, Integer>();
            mapaTipoImg.put("Colectivo", R.drawable.colectivo);
            mapaTipoImg.put("Cgp", R.drawable.cgp);
            mapaTipoImg.put("Banco", R.drawable.banco);
            mapaTipoImg.put("LocalComercial", R.drawable.localcomercial);

        }
        return mapaTipoImg;
    }

    private Map<String, Integer> getMapaTipoLayout() {
        if (mapaTipoLayout == null) {
            mapaTipoLayout = new HashMap<String, Integer>();
            mapaTipoLayout.put("Colectivo", R.layout.colectivo_detail);
            mapaTipoLayout.put("Cgp", R.layout.cgp_detail);
            mapaTipoLayout.put("Banco", R.layout.banco_detail);
            mapaTipoLayout.put("LocalComercial", R.layout.localcomercial_detail);

        }
        return mapaTipoLayout;
    }

    public int getImgTipo(Poi poi) {
        Integer result = getMapaTipoImg().get(poi.getTipo());
        if (result == null) {
            return R.drawable.error;
        }
        return result.intValue();
    }

    public int getLayoutTipo(Poi poi) {
        Integer result = getMapaTipoLayout().get(poi.getTipo());
        if (result == null) {
            return R.layout.colectivo_detail;
        }
        return result.intValue();
    }

}
