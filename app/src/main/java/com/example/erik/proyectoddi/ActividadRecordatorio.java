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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActividadRecordatorio extends AppCompatActivity {
    private Context mContext;
    //private ImageAdapter imAdapt;
    public int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__recordatorio);
        //imAdapt = new ImageAdapter(this);

        GridView gridView = (GridView) findViewById(R.id.mainGrdiViewRecordatorio);
        //gridView.setAdapter(imAdapt);
        gridView.addView(createNewRecordatorio());

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

    public TextView createNewRecordatorio(){
        Recordatorio recordatorio = new Recordatorio();
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView text = new TextView(this);
        text.setLayoutParams(lParams);
        text.setText(recordatorio.getNombre()+"\n"+recordatorio.getFecha());
        return text;

    }
}
