
        package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Email {

    @SerializedName("nombre_especialidad")
    @Expose
    private String nombreEspecialidad;
    @SerializedName("nombre_centroMedico")
    @Expose
    private String nombreCentroMedico;
    @SerializedName("nombre_medico")
    @Expose
    private String nombreMedico;
    @SerializedName("id_medico")
    @Expose
    private Integer idMedico;
    @SerializedName("nomb_usuario")
    @Expose
    private String nombUsuario;
    @SerializedName("id_centroMedico")
    @Expose
    private Integer id_centroMedico;

    public Email() {
    }

    public Email(String nombreEspecialidad, String nombreCentroMedico, String nombreMedico, Integer idMedico, String nombUsuario) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.nombreCentroMedico = nombreCentroMedico;
        this.nombreMedico = nombreMedico;
        this.idMedico = idMedico;
        this.nombUsuario = nombUsuario;
    }

    public Email(String nombreEspecialidad, String nombreCentroMedico, String nombreMedico, Integer idMedico, String nombUsuario, Integer id_centroMedico) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.nombreCentroMedico = nombreCentroMedico;
        this.nombreMedico = nombreMedico;
        this.idMedico = idMedico;
        this.nombUsuario = nombUsuario;
        this.id_centroMedico = id_centroMedico;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public Integer getId_centroMedico() {
        return id_centroMedico;
    }

    public void setId_centroMedico(Integer id_centroMedico) {
        this.id_centroMedico = id_centroMedico;
    }

    public String getNombreCentroMedico() {
        return nombreCentroMedico;
    }

    public void setNombreCentroMedico(String nombreCentroMedico) {
        this.nombreCentroMedico = nombreCentroMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombUsuario() {
        return nombUsuario;
    }

    public void setNombUsuario(String nombUsuario) {
        this.nombUsuario = nombUsuario;
    }

    @Override
    public String toString() {
        return "Email{" +
                "nombreEspecialidad='" + nombreEspecialidad + '\'' +
                ", nombreCentroMedico='" + nombreCentroMedico + '\'' +
                ", nombreMedico='" + nombreMedico + '\'' +
                ", idMedico=" + idMedico +
                ", nombUsuario='" + nombUsuario + '\'' +
                ", id_centroMedico=" + id_centroMedico +
                '}';
    }
}
