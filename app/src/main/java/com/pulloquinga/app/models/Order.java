package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("amount")
    @Expose
    private double amount;
    @SerializedName("tax_percentage")
    @Expose
    private double tax_percentage;
    @SerializedName("taxable_amount")
    @Expose
    private double taxable_amount;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("dev_reference")
    @Expose
    private String dev_reference;
    @SerializedName("vat")
    @Expose
    private double vat;

    public Order() {
    }

    public Order(double amount, double tax_percentage, double taxable_amount, String description, String dev_reference, double vat) {
        this.amount = amount;
        this.tax_percentage = tax_percentage;
        this.taxable_amount = taxable_amount;
        this.description = description;
        this.dev_reference = dev_reference;
        this.vat = vat;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTax_percentage() {
        return tax_percentage;
    }

    public void setTax_percentage(double tax_percentage) {
        this.tax_percentage = tax_percentage;
    }

    public double getTaxable_amount() {
        return taxable_amount;
    }

    public void setTaxable_amount(double taxable_amount) {
        this.taxable_amount = taxable_amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDev_reference() {
        return dev_reference;
    }

    public void setDev_reference(String dev_reference) {
        this.dev_reference = dev_reference;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                ", tax_percentage=" + tax_percentage +
                ", taxable_amount=" + taxable_amount +
                ", description='" + description + '\'' +
                ", dev_reference='" + dev_reference + '\'' +
                ", vat=" + vat +
                '}';
    }
}
