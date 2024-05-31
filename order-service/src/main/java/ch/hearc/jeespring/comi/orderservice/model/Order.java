package ch.hearc.jeespring.comi.orderservice.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String beerName;
    private int quantity;

    public Order() {
    }

    public Order(String beerName, int quantity) {
        this.beerName = beerName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", beerName='" + beerName + "', quantity=" + quantity + "}";
    }

    // getters and setters

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
