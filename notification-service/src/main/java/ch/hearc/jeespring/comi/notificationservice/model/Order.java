package ch.hearc.jeespring.comi.notificationservice.model;

import java.io.Serializable;

public class Order implements Serializable {
    private Long id;
    private String beerName;
    private int quantity;

    // getters and setters

    public Order(Long id, String beerName, int quantity) {
        this.id = id;
        this.beerName = beerName;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
