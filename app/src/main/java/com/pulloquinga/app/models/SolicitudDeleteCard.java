
        package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SolicitudDeleteCard {

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("card")
    @Expose
    private Card card;

    public SolicitudDeleteCard() {
    }

    public SolicitudDeleteCard(User user, Card card) {
        this.user = user;
        this.card = card;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "SolicitudDeleteCard{" +
                "user=" + user.toString() +
                ", card=" + card.toString() +
                '}';
    }
}

