package ar.edu.unsam.poiapp;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import ar.edu.unsam.poiapp.adapter.BancoAdapter;
import ar.edu.unsam.poiapp.adapter.CgpAdapter;
import ar.edu.unsam.poiapp.adapter.ColectivoAdapter;
import ar.edu.unsam.poiapp.adapter.DetalleAdapter;
import ar.edu.unsam.poiapp.adapter.LocalComercialAdapter;
import ar.edu.unsam.poiapp.adapter.TipoAdapter;
import ar.edu.unsam.poiapp.domain.Detalle;
import ar.edu.unsam.poiapp.domain.Poi;
import ar.edu.unsam.poiapp.repo.RepoPois;
import ar.edu.unsam.poiapp.service.PoiService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A fragment representing a single Poi detail screen.
 * This fragment is either contained in a {@link PoiListActivity}
 * in two-pane mode (on tablets) or a {@link PoiDetailActivity}
 * on handsets.
 */
public class PoiDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Poi poi;
    private PoiService poiservice;
    private View rootView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PoiDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments().containsKey(ARG_ITEM_ID)) {

            poi = (Poi) getArguments().get(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(poi.getNombre());  // Aca va el titulo de la barra superior de detalle
            } else {
                activity.setTitle(poi.getNombre());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //this.rootView = inflater.inflate(R.layout.colectivo_detail, container, false);

        this.rootView = inflater.inflate(new TipoAdapter().getLayoutTipo(poi), container, false);

        if (Objects.equals(poi.getTipo(), "Colectivo")) {
            new ColectivoAdapter().getView(rootView,poi);
        }
        if (Objects.equals(poi.getTipo(), "Banco")) {
            new BancoAdapter().getView(rootView,poi);
        }
        if (Objects.equals(poi.getTipo(), "Cgp")) {
            new CgpAdapter().getView(rootView,poi);
        }
        if (Objects.equals(poi.getTipo(), "LocalComercial")) {
            new LocalComercialAdapter().getView(rootView,poi);
        }

        return rootView;
    }

}

