package com.example.erik.proyectoddi;

import android.content.Context;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__recordatorio);

        GridView gridView = (GridView) findViewById(R.id.mainGrdiViewRecordatorio);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActividadRecordatorio.this, ""+ position, Toast.LENGTH_SHORT).show();
            }
        });

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

        GridView vista = (GridView) findViewById(R.id.mainGrdiViewRecordatorio);
        vista.addView(createNewRecordatorio());

    }

    public Button createNewRecordatorio(){
        Button boton = new Button(mContext);
        boton.setLayoutParams(new GridView.LayoutParams(85,85));
        boton.setText("Ejemplo");
        return boton;
    }
}
