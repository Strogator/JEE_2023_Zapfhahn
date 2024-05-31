package ch.hearc.jeespring.comi.notificationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;

    public Notification() {
    }

    public Notification(String message) {
        this.message = message;
    }

    // Getters and setters
}
