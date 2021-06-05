package com.pulloquinga.app;

public class Noticia {
    private int id_noticia;
    private  String titulo;
    private  String imagen;
    private  String descripcion;

    public Noticia(int id_noticia, String titulo, String imagen, String descripcion) {
        this.id_noticia = id_noticia;
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public int getId_noticia() {
        return id_noticia;
    }

    public void setId_noticia(int id_noticia) {
        this.id_noticia = id_noticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id_noticia=" + id_noticia +
                ", titulo='" + titulo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
