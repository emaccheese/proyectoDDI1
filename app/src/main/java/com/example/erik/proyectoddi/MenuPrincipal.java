package com.example.erik.proyectoddi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MenuPrincipal extends AppCompatActivity {
    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;
    ViewGroup menuPrincipal;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        menuPrincipal = (ViewGroup) findViewById(R.id.menu_principal);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_principal, menu);
        return true;
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

    public void clckOpcion(View view){

        TransitionManager.beginDelayedTransition(menuPrincipal);

        layout1 = (LinearLayout) findViewById(R.id.layoutBoton1);
        layout2 = (LinearLayout) findViewById(R.id.layoutBoton2);
        layout3 = (LinearLayout) findViewById(R.id.layoutBoton3);

        setNewParameters(view.getId(),layout1,layout2,layout3);
    }

    public void setNewParameters(int viewID,LinearLayout l1, LinearLayout l2, LinearLayout l3){

        LinearLayout.LayoutParams parametrosNuevos1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1);
        LinearLayout.LayoutParams parametrosNuevos2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,2);
        LinearLayout.LayoutParams parametrosNuevos3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,3);
        LinearLayout.LayoutParams parametrosNuevos5 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,5);
        final Handler handler = new Handler();

        if(viewID == R.id.botonOpcion1) {

            layout1.setLayoutParams(parametrosNuevos5);

            layout2.setLayoutParams(parametrosNuevos2);

            layout3.setLayoutParams(parametrosNuevos1);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 100ms
                    //Iniciar Leer
                    intentActivity(ActividadLeer.class );

                }
            }, 1000);

        }else {
            if (viewID == R.id.botonOpcion2) {


                layout1.setLayoutParams(parametrosNuevos1);

                layout2.setLayoutParams(parametrosNuevos5);

                layout3.setLayoutParams(parametrosNuevos2);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 100ms
                        //Iniciar Radio
                        intentActivity(ActividadRadio.class);
                    }
                }, 1000);

            } else if (viewID == R.id.botonOpcion3) {


                layout1.setLayoutParams(parametrosNuevos1);


                layout2.setLayoutParams(parametrosNuevos2);


                layout3.setLayoutParams(parametrosNuevos5);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 100ms
                        //Iniciar Recordatorio
                        intentActivity(ActividadRecordatorio.class);

                    }
                }, 1000);

            }
        }


    }

    public void intentActivity(Class x){

        intent = new Intent(this, x );
        startActivity(intent);
    }
}
