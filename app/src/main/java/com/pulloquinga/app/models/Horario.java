package com.pulloquinga.app.models;

import java.io.Serializable;

public class Horario implements Serializable {
    private int id_horario;
    private String fecha;
    private int id_hora;
    private String hora;
    private int id_medico;
    private String nombre_medico;

    public Horario(int id_horario, String fecha, int id_hora, String hora, int id_medico, String nombre_medico) {
        this.id_horario = id_horario;
        this.fecha = fecha;
        this.id_hora = id_hora;
        this.hora = hora;
        this.id_medico = id_medico;
        this.nombre_medico = nombre_medico;
    }

    public Horario() {
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_hora() {
        return id_hora;
    }

    public void setId_hora(int id_hora) {
        this.id_hora = id_hora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id_horario=" + id_horario +
                ", fecha='" + fecha + '\'' +
                ", id_hora=" + id_hora +
                ", hora='" + hora + '\'' +
                ", id_medico=" + id_medico +
                ", nombre_medico='" + nombre_medico + '\'' +
                '}';
    }
}
