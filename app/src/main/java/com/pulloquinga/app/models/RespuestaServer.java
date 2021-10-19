package com.pulloquinga.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RespuestaServer implements Serializable {
    @SerializedName("mensaje")
    String mensaje;

    public RespuestaServer(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "RespuestaServer{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }
}
