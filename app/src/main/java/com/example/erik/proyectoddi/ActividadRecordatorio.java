package com.example.erik.proyectoddi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActividadRecordatorio extends AppCompatActivity {
    private Context mContext;
    static final int DETALLES_RECORDATORIO_REQUEST = 0;
    public LinearLayout linearLayoutRecordatorio;
    public final static String LISTA_PARAMETROS = "com.example.erik.proyectoddi.LISTA_PARAMETROS";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__recordatorio);


        /*gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActividadRecordatorio.this, ""+ position, Toast.LENGTH_SHORT).show();
            }
        });*/

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void agregarRecordatorio(View view){
        Intent intent = new Intent(this, AgregarRecordatorio.class);
        startActivityForResult(intent,DETALLES_RECORDATORIO_REQUEST);

        //GridView vista = (GridView) findViewById(R.id.mainGrdiViewRecordatorio);


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        linearLayoutRecordatorio = (LinearLayout) findViewById(R.id.linearLayoutRecordatorios);
        final LinearLayout.LayoutParams lparamsX = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200);
        if (requestCode == 0) {
            if(resultCode == Activity.RESULT_OK){
                String [] informacionRecordatorio=data.getStringArrayExtra(AgregarRecordatorio.INFORMACION_RECORDATORIO);

                Toast.makeText(ActividadRecordatorio.this, informacionRecordatorio[1], Toast.LENGTH_LONG).show();
                CardView tarjeta = new CardView(this);
                tarjeta.setLayoutParams(lparamsX);
                tarjeta.setCardBackgroundColor(Color.LTGRAY);
                tarjeta.setRadius(20);
                tarjeta.addView(crearNuevoRecordatorio(informacionRecordatorio));


                linearLayoutRecordatorio.addView(tarjeta);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    public TextView crearNuevoRecordatorio(final String [] listaParametros){

        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        final Intent intent = new Intent(this, EditarRecordatorio.class);

        textView.setLayoutParams(lparams);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(35);
        if(listaParametros[0].equals("")) listaParametros[0]= "Sin Nombre";
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // do you work here
                //Toast.makeText(ActividadRecordatorio.this, listaParametros[1], Toast.LENGTH_LONG).show();
                intent.putExtra(LISTA_PARAMETROS,listaParametros);
                startActivityForResult(intent, DETALLES_RECORDATORIO_REQUEST);
            }
        });

        textView.setText(listaParametros[0]+"\t"+listaParametros[1]+"\t"+listaParametros[2]);
        return textView;
    }

}
