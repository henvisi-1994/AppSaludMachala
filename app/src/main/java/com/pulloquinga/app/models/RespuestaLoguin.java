package com.pulloquinga.app.models;

import java.io.Serializable;

public class RespuestaLoguin implements Serializable {
      String access_token;
      String token_type;
      String user;

    public RespuestaLoguin() {

    }

    public RespuestaLoguin(String access_token, String token_type, String user) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.user = user;
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
                '}';
    }
}
