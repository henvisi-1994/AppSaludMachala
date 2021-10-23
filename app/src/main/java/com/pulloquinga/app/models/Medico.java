package com.pulloquinga.app.models;

import java.io.Serializable;

public class Medico implements Serializable {
    private int id_medico;
    private int id_medico_prod;
    private String tipo_medico;
    private int id_detalleCentroMed;
    private int id_centroMedico;
    private String nombre_medico;
    private int id_especialidad;
    private String nombre_especialidad;
    private String nombre_centroMedico;
    private double valor;


    public Medico(int id_medico, String tipo_medico, int id_detalleCentroMed, int id_centroMedico, String nombre_medico, int id_especialidad, String nombre_especialidad) {
        this.id_medico = id_medico;
        this.tipo_medico = tipo_medico;
        this.id_detalleCentroMed = id_detalleCentroMed;
        this.id_centroMedico = id_centroMedico;
        this.nombre_medico = nombre_medico;
        this.id_especialidad = id_especialidad;
        this.nombre_especialidad = nombre_especialidad;
    }

    public Medico(int id_medico, int id_medico_prod, String tipo_medico, int id_detalleCentroMed, int id_centroMedico, String nombre_medico, int id_especialidad, String nombre_especialidad, String nombre_centroMedico, double valor) {
        this.id_medico = id_medico;
        this.id_medico_prod = id_medico_prod;
        this.tipo_medico = tipo_medico;
        this.id_detalleCentroMed = id_detalleCentroMed;
        this.id_centroMedico = id_centroMedico;
        this.nombre_medico = nombre_medico;
        this.id_especialidad = id_especialidad;
        this.nombre_especialidad = nombre_especialidad;
        this.nombre_centroMedico = nombre_centroMedico;
        this.valor = valor;
    }

    public Medico() {

    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Medico(int id_medico, int id_medico_prod, String tipo_medico, int id_detalleCentroMed, int id_centroMedico, String nombre_medico, int id_especialidad, String nombre_especialidad) {
        this.id_medico = id_medico;
        this.id_medico_prod = id_medico_prod;
        this.tipo_medico = tipo_medico;
        this.id_detalleCentroMed = id_detalleCentroMed;
        this.id_centroMedico = id_centroMedico;
        this.nombre_medico = nombre_medico;
        this.id_especialidad = id_especialidad;
        this.nombre_especialidad = nombre_especialidad;
    }

    public Medico(int id_medico, int id_medico_prod, String tipo_medico, int id_detalleCentroMed, int id_centroMedico, String nombre_medico, int id_especialidad, String nombre_especialidad, String nombre_centroMedico) {
        this.id_medico = id_medico;
        this.id_medico_prod = id_medico_prod;
        this.tipo_medico = tipo_medico;
        this.id_detalleCentroMed = id_detalleCentroMed;
        this.id_centroMedico = id_centroMedico;
        this.nombre_medico = nombre_medico;
        this.id_especialidad = id_especialidad;
        this.nombre_especialidad = nombre_especialidad;
        this.nombre_centroMedico = nombre_centroMedico;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_medico_prod() {
        return id_medico_prod;
    }

    public void setId_medico_prod(int id_medico_prod) {
        this.id_medico_prod = id_medico_prod;
    }

    public String getTipo_medico() {
        return tipo_medico;
    }

    public void setTipo_medico(String tipo_medico) {
        this.tipo_medico = tipo_medico;
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

    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
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

    public String getNombre_centroMedico() {
        return nombre_centroMedico;
    }

    public void setNombre_centroMedico(String nombre_centroMedico) {
        this.nombre_centroMedico = nombre_centroMedico;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id_medico=" + id_medico +
                ", id_medico_prod=" + id_medico_prod +
                ", tipo_medico='" + tipo_medico + '\'' +
                ", id_detalleCentroMed=" + id_detalleCentroMed +
                ", id_centroMedico=" + id_centroMedico +
                ", nombre_medico='" + nombre_medico + '\'' +
                ", id_especialidad=" + id_especialidad +
                ", nombre_especialidad='" + nombre_especialidad + '\'' +
                ", nombre_centroMedico='" + nombre_centroMedico + '\'' +
                ", valor=" + valor +
                '}';
    }
}
