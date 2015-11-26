package com.example.erik.proyectoddi;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EditarRecordatorio extends AppCompatActivity {
    public String [] datosRecordatorio;
    public TextView tvNombre;
    public TextView tvHora;
    public TextView tvFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_recordatorio);
        Intent intent = getIntent();
        datosRecordatorio = intent.getStringArrayExtra(ActividadRecordatorio.LISTA_PARAMETROS);
        tvNombre = (TextView) findViewById(R.id.tvNombreEditInput);
        tvNombre.setText(datosRecordatorio[0]);
        tvHora = (TextView) findViewById(R.id.tvHoraEditInput);
        tvHora.setText(datosRecordatorio[1]);
        tvFecha = (TextView) findViewById(R.id.tvDiaEditInput);
        tvFecha.setText(datosRecordatorio[2]);
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
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
