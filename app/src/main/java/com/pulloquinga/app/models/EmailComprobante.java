
        package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailComprobante {

    @SerializedName("nombre_especialidad")
    @Expose
    private String nombreEspecialidad;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("nombre_medico")
    @Expose
    private String nombreMedico;
    @SerializedName("hora")
    @Expose
    private String hora;
    @SerializedName("centroMedico")
    @Expose
    private String centroMedico;
    @SerializedName("fecha_cita")
    @Expose
    private String fecha_cita;
    @SerializedName("identificacion")
    @Expose
    private String identificacion;
    @SerializedName("nomb_usuario")
    @Expose
    private String nombUsuario;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("autorizacion")
    @Expose
    private String autorizacion;
    @SerializedName("amount")
    @Expose
    private Double amount;

    public EmailComprobante() {
    }

    public EmailComprobante(String nombreEspecialidad, String email, String hora, String centroMedico, String fecha_cita, String nombreMedico, String identificacion, String nombUsuario, String id, Double amount,String autorizacion) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.email = email;
        this.hora = hora;
        this.centroMedico = centroMedico;
        this.fecha_cita = fecha_cita;
        this.nombreMedico = nombreMedico;
        this.identificacion = identificacion;
        this.nombUsuario = nombUsuario;
        this.id = id;
        this.amount = amount;
        this.autorizacion=autorizacion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCentroMedico() {
        return centroMedico;
    }

    public void setCentroMedico(String centroMedico) {
        this.centroMedico = centroMedico;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombUsuario() {
        return nombUsuario;
    }

    public void setNombUsuario(String nombUsuario) {
        this.nombUsuario = nombUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    @Override
    public String toString() {
        return "EmailComprobante{" +
                "nombreEspecialidad='" + nombreEspecialidad + '\'' +
                ", email='" + email + '\'' +
                ", nombreMedico='" + nombreMedico + '\'' +
                ", hora='" + hora + '\'' +
                ", centroMedico='" + centroMedico + '\'' +
                ", fecha_cita='" + fecha_cita + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", nombUsuario='" + nombUsuario + '\'' +
                ", id='" + id + '\'' +
                ", autorizacion='" + autorizacion + '\'' +
                ", amount=" + amount +
                '}';
    }
}

