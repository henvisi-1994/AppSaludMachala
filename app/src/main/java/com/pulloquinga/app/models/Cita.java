package com.pulloquinga.app.models;

import java.io.Serializable;

public class Cita implements Serializable {
    private int id_cita;
    private int id_especialidad;
    private int id_horario;
    private int id_medico;

    public Cita() {

    }

    public Cita(int id_cita, int id_especialidad, int id_horario, int id_medico) {
        this.id_cita = id_cita;
        this.id_especialidad = id_especialidad;
        this.id_horario = id_horario;
        this.id_medico = id_medico;
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

    @Override
    public String toString() {
        return "Cita{" +
                "id_cita=" + id_cita +
                ", id_especialidad=" + id_especialidad +
                ", id_horario=" + id_horario +
                ", id_medico=" + id_medico +
                '}';
    }
}
