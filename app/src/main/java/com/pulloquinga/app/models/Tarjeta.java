package com.pulloquinga.app.models;

import java.io.Serializable;

public class Tarjeta implements Serializable {

        private String bin;
            private String status;
            private String token;
            private String holder_name;
            private String expiry_year;
            private String expiry_month;
            private String transaction_reference;
            private String type;
            private String number;

    public Tarjeta() {

    }

    public Tarjeta(String bin, String status, String token, String holder_name, String expiry_year, String expiry_month, String transaction_reference, String type, String number) {
        this.bin = bin;
        this.status = status;
        this.token = token;
        this.holder_name = holder_name;
        this.expiry_year = expiry_year;
        this.expiry_month = expiry_month;
        this.transaction_reference = transaction_reference;
        this.type = type;
        this.number = number;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHolder_name() {
        return holder_name;
    }

    public void setHolder_name(String holder_name) {
        this.holder_name = holder_name;
    }

    public String getExpiry_year() {
        return expiry_year;
    }

    public void setExpiry_year(String expiry_year) {
        this.expiry_year = expiry_year;
    }

    public String getExpiry_month() {
        return expiry_month;
    }

    public void setExpiry_month(String expiry_month) {
        this.expiry_month = expiry_month;
    }

    public String getTransaction_reference() {
        return transaction_reference;
    }

    public void setTransaction_reference(String transaction_reference) {
        this.transaction_reference = transaction_reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "bin='" + bin + '\'' +
                ", status='" + status + '\'' +
                ", token='" + token + '\'' +
                ", holder_name='" + holder_name + '\'' +
                ", expiry_year='" + expiry_year + '\'' +
                ", expiry_month='" + expiry_month + '\'' +
                ", transaction_reference='" + transaction_reference + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
