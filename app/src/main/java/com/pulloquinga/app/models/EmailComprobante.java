
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
    @SerializedName("identificacion")
    @Expose
    private String identificacion;
    @SerializedName("nomb_usuario")
    @Expose
    private String nombUsuario;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("amount")
    @Expose
    private Double amount;

    public EmailComprobante() {
    }

    public EmailComprobante(String nombreEspecialidad, String email, String nombreMedico, String identificacion, String nombUsuario, String id, Double amount) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.email = email;
        this.nombreMedico = nombreMedico;
        this.identificacion = identificacion;
        this.nombUsuario = nombUsuario;
        this.id = id;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "EmailComprobante{" +
                "nombreEspecialidad='" + nombreEspecialidad + '\'' +
                ", email='" + email + '\'' +
                ", nombreMedico='" + nombreMedico + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", nombUsuario='" + nombUsuario + '\'' +
                ", id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}

