package com.pulloquinga.app.models;

import java.io.Serializable;

public class CentroMedico implements Serializable {
    private int id;
    private String nombre;
    private String especialidades;
    private String direccion;
    private String telefono;
    private String ubicacion;

    public CentroMedico(int id, String nombre, String especialidades, String direccion, String telefono, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.especialidades = especialidades;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }

    public CentroMedico(int id, String nombre, String direccion, String telefono, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "CentroMedico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidades='" + especialidades + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
