
        package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RespuestaHistorial {

    @SerializedName("id_cita")
    @Expose
    private Integer idCita;
    @SerializedName("id_usuario")
    @Expose
    private Integer idUsuario;
    @SerializedName("id_especialidad")
    @Expose
    private Integer idEspecialidad;
    @SerializedName("nombre_especialidad")
    @Expose
    private String nombreEspecialidad;
    @SerializedName("id_medico")
    @Expose
    private Integer idMedico;
    @SerializedName("nombre_medico")
    @Expose
    private String nombreMedico;
    @SerializedName("id_horario")
    @Expose
    private Integer idHorario;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("nombre_centroMedico")
    @Expose
    private String nombre_centroMedico;
    @SerializedName("id_hora")
    @Expose
    private Integer idHora;
    @SerializedName("hora")
    @Expose
    private String hora;

    public RespuestaHistorial() {
    }

    public RespuestaHistorial(Integer idCita, Integer idUsuario, Integer idEspecialidad, String nombreEspecialidad, Integer idMedico, String nombreMedico, Integer idHorario, String fecha, String nombre_centroMedico, Integer idHora, String hora) {
        this.idCita = idCita;
        this.idUsuario = idUsuario;
        this.idEspecialidad = idEspecialidad;
        this.nombreEspecialidad = nombreEspecialidad;
        this.idMedico = idMedico;
        this.nombreMedico = nombreMedico;
        this.idHorario = idHorario;
        this.fecha = fecha;
        this.nombre_centroMedico = nombre_centroMedico;
        this.idHora = idHora;
        this.hora = hora;
    }

    public String getNombre_centroMedico() {
        return nombre_centroMedico;
    }

    public void setNombre_centroMedico(String nombre_centroMedico) {
        this.nombre_centroMedico = nombre_centroMedico;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getIdHora() {
        return idHora;
    }

    public void setIdHora(Integer idHora) {
        this.idHora = idHora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "RespuestaHistorial{" +
                "idCita=" + idCita +
                ", idUsuario=" + idUsuario +
                ", idEspecialidad=" + idEspecialidad +
                ", nombreEspecialidad='" + nombreEspecialidad + '\'' +
                ", idMedico=" + idMedico +
                ", nombreMedico='" + nombreMedico + '\'' +
                ", idHorario=" + idHorario +
                ", fecha='" + fecha + '\'' +
                ", nombre_centroMedico='" + nombre_centroMedico + '\'' +
                ", idHora=" + idHora +
                ", hora='" + hora + '\'' +
                '}';
    }
}
