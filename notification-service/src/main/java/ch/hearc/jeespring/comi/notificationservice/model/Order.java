package ch.hearc.jeespring.comi.notificationservice.model;

import java.io.Serializable;

public class Order implements Serializable {
    private Long id;
    private String beerName;
    private int quantity;

    public Order() {
    }

    public Order(Long id, String beerName, int quantity) {
        this.id = id;
        this.beerName = beerName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", beerName='" + beerName + "', quantity=" + quantity + "}";
    }

    public Long getId() {
        return id;
    }

    public String getBeerName() {
        return beerName;
    }

    public int getQuantity() {
        return quantity;
    }

}
