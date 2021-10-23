package com.pulloquinga.app.models;

import java.io.Serializable;

public class RespuestaLoguin implements Serializable {
      String access_token;
      String token_type;
      String user;
        String email;
        String identificacion;

    public RespuestaLoguin() {

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
                '}';
    }
}
