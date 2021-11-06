package com.pulloquinga.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Usuario implements Serializable {
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
    @SerializedName("telefono")
    String telefono;
    @SerializedName("identificacion")
    String identificacion;
    @SerializedName("direccion")
    String direccion;
    @SerializedName("id")
    int id;
    @SerializedName("clave")
    String clave;

    public Usuario(String name, String email, String password, String telefono, String identificacion, String direccion) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.direccion = direccion;
    }

    public Usuario(String name, String email, String password, String telefono, String identificacion, String direccion, int id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.id = id;
    }

    public Usuario(String name, String email, String password, String telefono, String identificacion, String direccion, int id, String clave) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.id = id;
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telefono='" + telefono + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

