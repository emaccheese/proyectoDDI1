package com.example.erik.proyectoddi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Erik on 11/1/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private GridView gView;

    public ImageAdapter(Context c ){
        mContext = c;
    }


    public int getCount() {

        return mThumbIds.length;
    }

   /* @Override
    public int getCount() {
        return 0;
    }*/

    @Override

    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    // Crear una nueva ImageView por cada opcion referida por el Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Button buttonView;
        if(convertView == null){
            // Si no esta reciclada, inicializa algunos atributos
            buttonView = new Button(mContext);
            buttonView.setLayoutParams(new GridView.LayoutParams(185, 85));
            //buttonView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            buttonView.setPadding(8, 8, 8, 8);
        } else{
            buttonView = (Button) convertView;
        }

        //buttonView.setImageResource(mThumbIds[position]);
        return buttonView;
    }

    // referencias a nuestras imagenes
    public Integer[] mThumbIds;/* = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };*/

}
