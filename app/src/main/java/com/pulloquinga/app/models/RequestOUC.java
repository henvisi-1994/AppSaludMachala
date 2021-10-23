
package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RequestOUC {

    @SerializedName("transaction")
    @Expose
    private Transaction transaction;
    @SerializedName("card")
    @Expose
    private Card card;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "RequestOUC{" +
                "transaction=" + transaction.toString() +
                ", card=" + card.toString() +
                '}';
    }
}



