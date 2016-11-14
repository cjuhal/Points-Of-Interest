package ar.edu.unsam.poiapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ar.edu.unsam.poiapp.R;
import ar.edu.unsam.poiapp.domain.Poi;
import ar.edu.unsam.poiapp.util.ImgUtil;


/**
 * Created by JD on 07/11/2016.
 */

public class PoiAdapter extends ArrayAdapter<Poi>{

    
        public PoiAdapter(Context context, List<Poi> pois) {
            super(context, R.layout.poi_row, pois);
        }

        @Override
        public long getItemId(int position) {
            //return position;
            return getItem(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.poi_row, parent, false);
            final Poi poi = getItem(position);

            TextView tvPoi = (TextView) rowView.findViewById(R.id.lblPoi);
            tvPoi.setText(poi.getNombre());

            TextView tvTipo = (TextView) rowView.findViewById(R.id.lblTipo);
            tvTipo.setText(poi.getTipo());

//            ImageView imgPoi = ((ImageView) rowView.findViewById(R.id.imgPoi));
//            imgPoi.setImageDrawable(getResources().getDrawable(new TipoAdapter().getImgTipo(poi)));

            ImageView myImageView = (ImageView) rowView.findViewById(R.id.imgPoi);
            myImageView.setImageResource(new TipoAdapter().getImgTipo(poi));

//            ImageView imgPoi = (ImageView) rowView.findViewById(R.id.imgPoi);
//            ImgUtil.assignImage(poi, imgPoi);


            return rowView;
        }

}

