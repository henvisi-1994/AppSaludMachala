
        package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequireEmailComprobante {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("especialidad")
    @Expose
    private String especialidad;
    @SerializedName("nomb_medico")
    @Expose
    private String nombMedico;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("identificacion")
    @Expose
    private String identificacion;
    @SerializedName("num_comprobante")
    @Expose
    private String numComprobante;
    @SerializedName("precio")
    @Expose
    private Integer precio;
    @SerializedName("auxhora")
    @Expose
    private String auxhora;
    @SerializedName("nomb_centMedico")
    @Expose
    private String nomb_centMedico;
    @SerializedName("auxFecha")
    @Expose
    private String auxFecha;


    public RequireEmailComprobante() {
    }

    public RequireEmailComprobante(String email, String username, String especialidad, String nombMedico, String fecha, String identificacion, String numComprobante, Integer precio) {
        this.email = email;
        this.username = username;
        this.especialidad = especialidad;
        this.nombMedico = nombMedico;
        this.fecha = fecha;
        this.identificacion = identificacion;
        this.numComprobante = numComprobante;
        this.precio = precio;
    }

    public RequireEmailComprobante(String email, String username, String especialidad, String nombMedico, String fecha, String identificacion, String numComprobante, Integer precio, String auxhora, String nomb_centMedico, String auxFecha) {
        this.email = email;
        this.username = username;
        this.especialidad = especialidad;
        this.nombMedico = nombMedico;
        this.fecha = fecha;
        this.identificacion = identificacion;
        this.numComprobante = numComprobante;
        this.precio = precio;
        this.auxhora = auxhora;
        this.nomb_centMedico = nomb_centMedico;
        this.auxFecha = auxFecha;
    }

    public String getAuxhora() {
        return auxhora;
    }

    public void setAuxhora(String auxhora) {
        this.auxhora = auxhora;
    }

    public String getNomb_centMedico() {
        return nomb_centMedico;
    }

    public void setNomb_centMedico(String nomb_centMedico) {
        this.nomb_centMedico = nomb_centMedico;
    }

    public String getAuxFecha() {
        return auxFecha;
    }

    public void setAuxFecha(String auxFecha) {
        this.auxFecha = auxFecha;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "RequireEmailComprobante{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", nombMedico='" + nombMedico + '\'' +
                ", fecha='" + fecha + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", numComprobante='" + numComprobante + '\'' +
                ", precio=" + precio +
                ", auxhora='" + auxhora + '\'' +
                ", nomb_centMedico='" + nomb_centMedico + '\'' +
                ", auxFecha='" + auxFecha + '\'' +
                '}';
    }
}

