package ar.edu.unsam.poiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;


import ar.edu.unsam.poiapp.domain.Poi;


/**
 * An activity representing a list of Peliculas. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link PoiDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link PoiListFragment} and the item details
 * (if present) is a {@link PoiDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link PoiListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class PoiListActivity extends AppCompatActivity
        implements PoiListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_app_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.poi_detail_container) != null) {
            mTwoPane = true;
            ((PoiListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.poi_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link PoiListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(Poi poi) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putSerializable(PoiDetailFragment.ARG_ITEM_ID, poi);
            PoiDetailFragment fragment = new PoiDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.poi_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, PoiDetailActivity.class);
            Log.w("Pois", poi.getNombre());
            detailIntent.putExtra(PoiDetailFragment.ARG_ITEM_ID, poi);
            startActivity(detailIntent);
        }
    }
}
