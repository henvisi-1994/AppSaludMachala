package com.pulloquinga.app.models;

import java.io.Serializable;

public class TokenPago implements Serializable {
    private String authtoken;

    public TokenPago() {
    }

    public TokenPago(String authtoken) {
        this.authtoken = authtoken;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    @Override
    public String toString() {
        return "TokenPago{" +
                "authtoken='" + authtoken + '\'' +
                '}';
    }
}
