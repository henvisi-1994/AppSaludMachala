package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CalificacionAppModel {

    @SerializedName("id_cita")
    @Expose
    private Integer idCita;
    @SerializedName("calificacion")
    @Expose
    private String calificacion;
    @SerializedName("comentario")
    @Expose
    private String comentario;

    public CalificacionAppModel() {
    }

    public CalificacionAppModel(Integer idCita, String calificacion, String comentario) {
        this.idCita = idCita;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "CalificacionAppModel{" +
                "idCita=" + idCita +
                ", calificacion='" + calificacion + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}

