package com.pulloquinga.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OUC {
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("order")
    @Expose
    private Order order;
    @SerializedName("card")
    @Expose
    private Card card;

    public OUC() {
    }

    public OUC(User user, Order order, Card card) {
        this.user = user;
        this.order = order;
        this.card = card;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "OUC{" +
                "user=" + user.toString() +
                ", order=" + order.toString() +
                ", card=" + card.toString() +
                '}';
    }
}
