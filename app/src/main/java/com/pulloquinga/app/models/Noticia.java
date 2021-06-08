package com.pulloquinga.app.models;

import java.io.Serializable;

public class Noticia implements Serializable {
    private int id_noticia;
    private  String titulo_noticia;
    private  String imagen_noticia;
    private  String descripcion_noticia;
    private String fecha_inicio_noticia;
    private String fecha_fin_noticia;

    public Noticia(int id_noticia, String titulo_noticia, String imagen_noticia, String descripcion_noticia, String fecha_inicio_noticia, String fecha_fin_noticia) {
        this.id_noticia = id_noticia;
        this.titulo_noticia = titulo_noticia;
        this.imagen_noticia = imagen_noticia;
        this.descripcion_noticia = descripcion_noticia;
        this.fecha_inicio_noticia = fecha_inicio_noticia;
        this.fecha_fin_noticia = fecha_fin_noticia;
    }

    public int getId_noticia() {
        return id_noticia;
    }

    public void setId_noticia(int id_noticia) {
        this.id_noticia = id_noticia;
    }

    public String getTitulo_noticia() {
        return titulo_noticia;
    }

    public void setTitulo_noticia(String titulo_noticia) {
        this.titulo_noticia = titulo_noticia;
    }

    public String getImagen_noticia() {
        return imagen_noticia;
    }

    public void setImagen_noticia(String imagen_noticia) {
        this.imagen_noticia = imagen_noticia;
    }

    public String getDescripcion_noticia() {
        return descripcion_noticia;
    }

    public void setDescripcion_noticia(String descripcion_noticia) {
        this.descripcion_noticia = descripcion_noticia;
    }

    public String getFecha_inicio_noticia() {
        return fecha_inicio_noticia;
    }

    public void setFecha_inicio_noticia(String fecha_inicio_noticia) {
        this.fecha_inicio_noticia = fecha_inicio_noticia;
    }

    public String getFecha_fin_noticia() {
        return fecha_fin_noticia;
    }

    public void setFecha_fin_noticia(String fecha_fin_noticia) {
        this.fecha_fin_noticia = fecha_fin_noticia;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id_noticia=" + id_noticia +
                ", titulo_noticia='" + titulo_noticia + '\'' +
                ", imagen_noticia='" + imagen_noticia + '\'' +
                ", descripcion_noticia='" + descripcion_noticia + '\'' +
                ", fecha_inicio_noticia='" + fecha_inicio_noticia + '\'' +
                ", fecha_fin_noticia='" + fecha_fin_noticia + '\'' +
                '}';
    }
}
