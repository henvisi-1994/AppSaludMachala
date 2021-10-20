
package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenPago {

    @SerializedName("authtoken")
    @Expose
    private String authtoken;

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

