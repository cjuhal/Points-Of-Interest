package ar.edu.unsam.poiapp.repo;

import ar.edu.unsam.poiapp.domain.Poi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;


/**
 * Created by JD on 07/11/2016.
 */

public class RepoPois {


    private List<Poi> pois;
   // private Map<String, Genero> generos;

    private static final int MAX_RESULTS = 10;

    /**
     * SINGLETON
     */
    private static RepoPois instance;

    private RepoPois() {
        pois = new ArrayList<Poi>();
       // generos = new HashMap<String, Genero>();
    }

    public static RepoPois getInstance() {
        if (instance == null) {
            instance = new RepoPois();
            instance.init();
        }
        return instance;
    }

    private void init() {

        RepoPois.getInstance().agregarPoi(new Poi("Banco Santander","Calle Sin Numero 123","colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("Linea 111",null,"colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("Verduleria Don Manolo","La Paz 666","colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("CGP La Boca","Madero 3453","colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("Banco Nacion","Av Membrillo 444","colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("Linea 343",null,"colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("Vivero Loto Azul","Rivadavia 10666","colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("CGP Urquiza","Galvan 3323","colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("Banco Provincia","Vereda 6765","colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("Linea 161",null,"colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("Verduleria Las Amandas","Guerra 777","colectivo"));
        RepoPois.getInstance().agregarPoi(new Poi("CGP Pompeya","Industria 1933","colectivo"));
    }



//    public Genero getGenero(String descripcionGenero) {
//        Genero genero = generos.get(descripcionGenero);
//        if (genero == null) {
//            generos.put(descripcionGenero, genero);
//            genero = new Genero(descripcionGenero);
//        }
//        return genero;
//    }

    public List<Poi> getPois(String nombre) {
        return getPois(nombre, MAX_RESULTS);
    }

    public List<Poi> getPois(String nombre, int max) {
        Iterator<Poi> it = pois.iterator();
        List<Poi> result = new ArrayList<Poi>();
        while (it.hasNext() && max > 0) {
            Poi poi = it.next();
            max--;
            if (nombre == null || poi.getNombre().toUpperCase().contains(nombre.toUpperCase())) {
                result.add(poi);
            }
        }
        return result;
    }

    public Poi getPoi(Long id) {
        for (Poi poi : this.pois) {
            if (poi.getId().equals(id)) {
                return poi;
            }
        }
        return null;
    }

    public void agregarPoi(Poi poi) {
        poi.setId(getMaximoId());
        pois.add(poi);
    }

    public Long getMaximoId() {
        return new Long(pois.size() + 1);
    }

    public List<String> getNombreDePois() {
        List<String> result = new ArrayList<>();
        for (Poi poi : this.getPois(null, 10)) {
            result.add(poi.getNombre());
        }
        return result;
    }

}
