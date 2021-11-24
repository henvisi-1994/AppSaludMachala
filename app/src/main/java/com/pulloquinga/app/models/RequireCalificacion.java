 package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequireCalificacion {

    @SerializedName("id_cita")
    @Expose
    private Integer idCita;
    @SerializedName("calificacion")
    @Expose
    private String calificacion;
    @SerializedName("comentario")
    @Expose
    private String comentario;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id_calificacion")
    @Expose
    private Integer idCalificacion;

    public RequireCalificacion() {
    }

    public RequireCalificacion(Integer idCita, String calificacion, String comentario, String updatedAt, String createdAt, Integer idCalificacion) {
        this.idCita = idCita;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.idCalificacion = idCalificacion;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    @Override
    public String toString() {
        return "RequireCalificacion{" +
                "idCita=" + idCita +
                ", calificacion='" + calificacion + '\'' +
                ", comentario='" + comentario + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", idCalificacion=" + idCalificacion +
                '}';
    }
}

