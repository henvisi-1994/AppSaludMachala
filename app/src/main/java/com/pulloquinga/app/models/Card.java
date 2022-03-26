
package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Card implements Serializable {

    @SerializedName("bin")
    @Expose
    private String bin;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("holder_name")
    @Expose
    private String holderName;
    @SerializedName("expiry_year")
    @Expose
    private String expiryYear;
    @SerializedName("expiry_month")
    @Expose
    private String expiryMonth;
    @SerializedName("transaction_reference")
    @Expose
    private String transactionReference;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("cvc")
    @Expose
    private String cvc;


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

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
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
        return "Card{" +
                "bin='" + bin + '\'' +
                ", status='" + status + '\'' +
                ", token='" + token + '\'' +
                ", holderName='" + holderName + '\'' +
                ", expiryYear='" + expiryYear + '\'' +
                ", expiryMonth='" + expiryMonth + '\'' +
                ", transactionReference='" + transactionReference + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", cvc='" + cvc + '\'' +
                '}';
    }
}




