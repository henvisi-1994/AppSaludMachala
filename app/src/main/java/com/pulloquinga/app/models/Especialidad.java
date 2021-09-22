package com.pulloquinga.app.models;

import java.io.Serializable;

public class Especialidad implements Serializable {
    private int id_especialidad;
    private String nombre_especialidad;

    public Especialidad(int id_especialidad, String nombre_especialidad) {
        this.id_especialidad = id_especialidad;
        this.nombre_especialidad = nombre_especialidad;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "id_especialidad=" + id_especialidad +
                ", nombre_especialidad='" + nombre_especialidad + '\'' +
                '}';
    }
}
