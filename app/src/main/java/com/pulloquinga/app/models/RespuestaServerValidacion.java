package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RespuestaServerValidacion {
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("conteo")
    @Expose
    private int conteo;
    public RespuestaServerValidacion() {
    }

    public int getConteo() {
        return conteo;
    }

    public void setConteo(int conteo) {
        this.conteo = conteo;
    }

    public RespuestaServerValidacion(String mensaje) {
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
