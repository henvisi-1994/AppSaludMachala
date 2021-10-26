package com.pulloquinga.app.models;

import java.io.Serializable;

public class CentroMedicoDB implements Serializable {
    private int id_centroMedico;
    private String nombre_centroMedico;
    private String direccion_centroMedico;
    private String telef_centroMedico;
    private String ubic_centroMedico;
    private String nombre_especialidad;


    public CentroMedicoDB(int id_centroMedico, String nombre_centroMedico, String direccion_centroMedico, String telef_centroMedico, String ubic_centroMedico) {
        this.id_centroMedico = id_centroMedico;
        this.nombre_centroMedico = nombre_centroMedico;
        this.direccion_centroMedico = direccion_centroMedico;
        this.telef_centroMedico = telef_centroMedico;
        this.ubic_centroMedico = ubic_centroMedico;
    }

    public CentroMedicoDB(int id_centroMedico, String nombre_centroMedico, String direccion_centroMedico, String telef_centroMedico, String ubic_centroMedico, String nombre_especialidad) {
        this.id_centroMedico = id_centroMedico;
        this.nombre_centroMedico = nombre_centroMedico;
        this.direccion_centroMedico = direccion_centroMedico;
        this.telef_centroMedico = telef_centroMedico;
        this.ubic_centroMedico = ubic_centroMedico;
        this.nombre_especialidad = nombre_especialidad;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    public int getId_centroMedico() {
        return id_centroMedico;
    }

    public void setId_centroMedico(int id_centroMedico) {
        this.id_centroMedico = id_centroMedico;
    }

    public String getNombre_centroMedico() {
        return nombre_centroMedico;
    }

    public void setNombre_centroMedico(String nombre_centroMedico) {
        this.nombre_centroMedico = nombre_centroMedico;
    }

    public String getDireccion_centroMedico() {
        return direccion_centroMedico;
    }

    public void setDireccion_centroMedico(String direccion_centroMedico) {
        this.direccion_centroMedico = direccion_centroMedico;
    }

    public String getTelef_centroMedico() {
        return telef_centroMedico;
    }

    public void setTelef_centroMedico(String telef_centroMedico) {
        this.telef_centroMedico = telef_centroMedico;
    }

    public String getUbic_centroMedico() {
        return ubic_centroMedico;
    }

    public void setUbic_centroMedico(String ubic_centroMedico) {
        this.ubic_centroMedico = ubic_centroMedico;
    }

    @Override
    public String toString() {
        return "CentroMedicoDB{" +
                "id_centroMedico=" + id_centroMedico +
                ", nombre_centroMedico='" + nombre_centroMedico + '\'' +
                ", direccion_centroMedico='" + direccion_centroMedico + '\'' +
                ", telef_centroMedico='" + telef_centroMedico + '\'' +
                ", ubic_centroMedico='" + ubic_centroMedico + '\'' +
                ", nombre_especialidad='" + nombre_especialidad + '\'' +
                '}';
    }
}

