
        package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RespuestaServer {

    @SerializedName("mensaje")
    @Expose
    private String mensaje;

    public RespuestaServer() {
    }

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
