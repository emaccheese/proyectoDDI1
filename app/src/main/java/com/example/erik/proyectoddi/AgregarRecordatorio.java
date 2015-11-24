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

import org.w3c.dom.Text;

import java.util.Calendar;

public class AgregarRecordatorio extends FragmentActivity {

    public final static String INFORMACION_RECORDATORIO = "com.example.erik.proyectoddi";
    public int hour;
    public int minute;
    public int year;
    public int month;
    public int day;
    public TextView tvDia;
    public TextView tvHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_recordatorio);
        Calendar calendar = Calendar.getInstance();

        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDia = (TextView) findViewById(R.id.tvDiaInput);
        tvHora = (TextView) findViewById(R.id.tvHoraInput);

        tvDia.setText(day+"/"+month+"/"+year);
        tvHora.setText(hour+":"+minute);
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
        TextView tvHoraRecordatorio = (TextView) findViewById(R.id.tvHoraInput);
        TextView tvDiaRecordatorio = (TextView) findViewById(R.id.tvDiaInput);


        parametrosRecordatorio[0] = etNombreRecordatorio.toString();
        parametrosRecordatorio[1] = tvHoraRecordatorio.getText().toString();
        parametrosRecordatorio[2] = tvDiaRecordatorio.getText().toString();

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



}
