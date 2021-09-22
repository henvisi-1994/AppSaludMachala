package com.pulloquinga.app.models;

public class DetalleCentroMedico {
    private int id_detalleCentroMed;
    private int id_centroMedico;
    private int id_especialidad;
    private String nombre_centroMedico;
    private String nombre_especialidad;

    public DetalleCentroMedico() {

    }

    public int getId_detalleCentroMed() {
        return id_detalleCentroMed;
    }

    public void setId_detalleCentroMed(int id_detalleCentroMed) {
        this.id_detalleCentroMed = id_detalleCentroMed;
    }

    public int getId_centroMedico() {
        return id_centroMedico;
    }

    public void setId_centroMedico(int id_centroMedico) {
        this.id_centroMedico = id_centroMedico;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getNombre_centroMedico() {
        return nombre_centroMedico;
    }

    public void setNombre_centroMedico(String nombre_centroMedico) {
        this.nombre_centroMedico = nombre_centroMedico;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    @Override
    public String toString() {
        return "DetalleCentroMedico{" +
                "id_detalleCentroMed=" + id_detalleCentroMed +
                ", id_centroMedico=" + id_centroMedico +
                ", id_especialidad=" + id_especialidad +
                ", nombre_centroMedico='" + nombre_centroMedico + '\'' +
                ", nombre_especialidad='" + nombre_especialidad + '\'' +
                '}';
    }

    public DetalleCentroMedico(int id_detalleCentroMed, int id_centroMedico, int id_especialidad, String nombre_centroMedico, String nombre_especialidad) {
        this.id_detalleCentroMed = id_detalleCentroMed;
        this.id_centroMedico = id_centroMedico;
        this.id_especialidad = id_especialidad;
        this.nombre_centroMedico = nombre_centroMedico;
        this.nombre_especialidad = nombre_especialidad;

    }
}
