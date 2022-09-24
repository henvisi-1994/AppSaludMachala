package com.pulloquinga.app.models;

import java.io.Serializable;

public class RespuestaLoguin implements Serializable {
      String access_token;
      String token_type;
      String user;
        String email;
        String identificacion;
    String telefono;
    String direccion;
    String clave;
    String email_verified_at="";
    int id;


    public RespuestaLoguin() {

    }

    public String getEmailVerifiedAt() {
        return email_verified_at;
    }

    public void setEmailVerifiedAt(String email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public RespuestaLoguin(String access_token, String token_type, String user) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.user = user;
    }

    public RespuestaLoguin(String access_token, String token_type, String user, String email, String identificacion) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.user = user;
        this.email = email;
        this.identificacion = identificacion;
    }

    public RespuestaLoguin(String access_token, String token_type, String user, String email, String identificacion, String telefono, String direccion, String clave) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.user = user;
        this.email = email;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.clave = clave;
    }

    public RespuestaLoguin(String access_token, String token_type, String user, String email, String identificacion, String telefono, String direccion, String clave, String email_verified_at, int id) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.user = user;
        this.email = email;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.clave = clave;
        this.id = id;
        this.email_verified_at=email_verified_at;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "RespuestaLoguin{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", clave='" + clave + '\'' +
                ", email_verified_at='" + email_verified_at + '\'' +
                ", id=" + id +
                '}';
    }
}
