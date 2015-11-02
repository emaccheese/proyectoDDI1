package com.example.erik.proyectoddi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * Created by Erik on 11/1/2015.
 */
public class RecordatorioAdapter extends BaseAdapter {
    public Button [] Recordatorios;

    private Context mContext;

    public RecordatorioAdapter(Context c ){
        mContext = c;
    }
    @Override
    public int getCount() {
        return Recordatorios.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button botonView;
        if(convertView == null){
            botonView = new Button(mContext);

        }else{
            botonView = (Button) convertView;
        }


        return null;
    }
}
