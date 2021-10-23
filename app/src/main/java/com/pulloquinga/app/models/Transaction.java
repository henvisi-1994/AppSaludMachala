package com.pulloquinga.app.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("authorization_code")
    @Expose
    private String authorizationCode;
    @SerializedName("status_detail")
    @Expose
    private Integer statusDetail;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("payment_date")
    @Expose
    private String paymentDate;
    @SerializedName("dev_reference")
    @Expose
    private String devReference;
    @SerializedName("carrier_code")
    @Expose
    private String carrierCode;
    @SerializedName("current_status")
    @Expose
    private String currentStatus;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("carrier")
    @Expose
    private String carrier;
    @SerializedName("installments")
    @Expose
    private Integer installments;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public Integer getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(Integer statusDetail) {
        this.statusDetail = statusDetail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDevReference() {
        return devReference;
    }

    public void setDevReference(String devReference) {
        this.devReference = devReference;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "status='" + status + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", statusDetail=" + statusDetail +
                ", message='" + message + '\'' +
                ", id='" + id + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", devReference='" + devReference + '\'' +
                ", carrierCode='" + carrierCode + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                ", amount=" + amount +
                ", carrier='" + carrier + '\'' +
                ", installments=" + installments +
                '}';
    }
}