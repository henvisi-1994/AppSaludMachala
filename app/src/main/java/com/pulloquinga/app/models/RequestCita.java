
        package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestCita {
    public RequestCita() {
    }

    public RequestCita(String mensaje) {
        this.mensaje = mensaje;
    }

    @SerializedName("mensaje")
    @Expose
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "RequestCita{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }
}

