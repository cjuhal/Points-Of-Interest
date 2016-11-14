package ar.edu.unsam.poiapp;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ar.edu.unsam.poiapp.domain.Poi;
import ar.edu.unsam.poiapp.repo.RepoPois;
import ar.edu.unsam.poiapp.service.PoiService;
import retrofit.GsonConverterFactory;
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

//            String idPoi = getArguments().getString(ARG_ITEM_ID);         //getSerializable en vez de String
//            poi = RepoPois.getInstance().getPoi(new Long(idPoi).longValue());

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
        View rootView = inflater.inflate(R.layout.poi_detail, container, false);

        if (poi != null) {
            ((TextView) rootView.findViewById(R.id.poi_detail)).setText(poi.getNombre());

            ((TextView) rootView.findViewById(R.id.poi_detail)).setText("Dirección: \n"+poi.getDireccion());
        }

        return rootView;
    }
}
