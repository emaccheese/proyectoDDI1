package com.example.erik.proyectoddi;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

public class AgregarRecordatorio extends FragmentActivity implements DatePickerDialog.OnDateSetListener {

    public final static String INFORMACION_RECORDATORIO = "com.example.erik.proyectoddi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_recordatorio);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        int j;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void regresarRecordatorio(View view){
        Intent returnIntent = new Intent();
        String [] parametrosRecordatorio = new String[3];
        //returnIntent.putExtra("result",result);
        EditText etNombreRecordatorio = (EditText) findViewById(R.id.etNombre);
        TextClock tcHoraRecordatorio = (TextClock) findViewById(R.id.textClock);
        TextView cvCalendario = (TextView) findViewById(R.id.tvDia);


        parametrosRecordatorio[0] = etNombreRecordatorio.toString();
        parametrosRecordatorio[1] = tcHoraRecordatorio.getText().toString();
        parametrosRecordatorio[2] = cvCalendario.toString();

        returnIntent.putExtra(INFORMACION_RECORDATORIO, parametrosRecordatorio);

        setResult(Activity.RESULT_OK, returnIntent);
        finish();

    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        //do some stuff for example write on log and update TextField on activity
        Log.w("DatePicker", "Date = " + year);
        ((TextView) findViewById(R.id.tvDia)).setText(month+"/"+day);
    }

}
