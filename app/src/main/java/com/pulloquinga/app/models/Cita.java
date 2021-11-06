package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cita implements Serializable {
    @SerializedName("id_cita")
    @Expose
    private int id_cita;
    @SerializedName("id_usuario")
    @Expose
    private int id_usuario;
    @SerializedName("id_especialidad")
    @Expose
    private int id_especialidad;
    @SerializedName("id_horario")
    @Expose
    private int id_horario;
    @SerializedName("id_medico")
    @Expose
    private int id_medico;
    @SerializedName("nomb_usuario")
    @Expose
    private String nomb_usuario;


    public Cita() {

    }

    public Cita(int id_cita, int id_especialidad, int id_horario, int id_medico) {
        this.id_cita = id_cita;
        this.id_especialidad = id_especialidad;
        this.id_horario = id_horario;
        this.id_medico = id_medico;
    }

    public Cita( int id_especialidad, int id_horario, int id_medico, String nomb_usuario) {
        this.id_especialidad = id_especialidad;
        this.id_horario = id_horario;
        this.id_medico = id_medico;
        this.nomb_usuario = nomb_usuario;
    }

    public Cita( int id_usuario, int id_especialidad, int id_horario, int id_medico, String nomb_usuario) {
        this.id_usuario = id_usuario;
        this.id_especialidad = id_especialidad;
        this.id_horario = id_horario;
        this.id_medico = id_medico;
        this.nomb_usuario = nomb_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getNomb_usuario() {
        return nomb_usuario;
    }

    public void setNomb_usuario(String nomb_usuario) {
        this.nomb_usuario = nomb_usuario;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id_cita=" + id_cita +
                ", id_usuario=" + id_usuario +
                ", id_especialidad=" + id_especialidad +
                ", id_horario=" + id_horario +
                ", id_medico=" + id_medico +
                ", nomb_usuario='" + nomb_usuario + '\'' +
                '}';
    }
}
