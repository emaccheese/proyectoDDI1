package com.example.erik.proyectoddi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class ActividadRecordatorio extends AppCompatActivity {
    private Context mContext;
    static final int DETALLES_RECORDATORIO_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__recordatorio);

        GridView gridView = (GridView) findViewById(R.id.mainGrdiViewRecordatorio);


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

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String [] informacionRecordatorio=data.getStringArrayExtra(AgregarRecordatorio.INFORMACION_RECORDATORIO);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

}
