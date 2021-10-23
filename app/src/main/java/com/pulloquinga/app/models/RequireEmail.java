
        package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequireEmail {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("especialidad")
    @Expose
    private String especialidad;
    @SerializedName("nomb_centro_medico")
    @Expose
    private String nombCentroMedico;
    @SerializedName("nomb_medico")
    @Expose
    private String nombMedico;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("hora")
    @Expose
    private String hora;

    public RequireEmail() {
    }

    public RequireEmail(String email, String username, String especialidad, String nombCentroMedico, String nombMedico, String fecha, String hora) {
        this.email = email;
        this.username = username;
        this.especialidad = especialidad;
        this.nombCentroMedico = nombCentroMedico;
        this.nombMedico = nombMedico;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombCentroMedico() {
        return nombCentroMedico;
    }

    public void setNombCentroMedico(String nombCentroMedico) {
        this.nombCentroMedico = nombCentroMedico;
    }

    public String getNombMedico() {
        return nombMedico;
    }

    public void setNombMedico(String nombMedico) {
        this.nombMedico = nombMedico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "RequireEmail{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", nombCentroMedico='" + nombCentroMedico + '\'' +
                ", nombMedico='" + nombMedico + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}

