package com.example.erik.proyectoddi;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Erik on 11/1/2015.
 */
public class Recordatorio {
    String nombre;
    String fecha;
    String descripcion;


    public Recordatorio(){
        nombre = "Nombre: ";
        fecha = "Fecha: ";
        descripcion = "Descripcion: ";
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre += nombre;
    }

    public void setFecha() {
        Calendar calendario = Calendar.getInstance();

        this.fecha += calendario.getTime().toString();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion += descripcion;
    }
}