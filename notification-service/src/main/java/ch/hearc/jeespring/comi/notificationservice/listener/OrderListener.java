package ch.hearc.jeespring.comi.notificationservice.listener;

import ch.hearc.jeespring.comi.notificationservice.model.Order;
import ch.hearc.jeespring.comi.notificationservice.service.EmailService;
import ch.hearc.jeespring.comi.notificationservice.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OrderListener {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private EmailService emailService;

    @Value("${email.address}")
    private String emailAddress;


    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveOrder(Message message) {
        try {
            if (message instanceof TextMessage) {
                String jsonOrder = ((TextMessage) message).getText();
                System.out.println("Received raw JSON: " + jsonOrder);
                Order order = objectMapper.readValue(jsonOrder, Order.class);
                System.out.println("Deserialized order: " + order);
                sendNotification(order);
            } else {
                System.err.println("Received message of unexpected type: " + message.getClass());
            }
        } catch (JMSException | IOException e) {
            System.err.println("Error deserializing order JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void sendNotification(Order order) {
        notificationService.createNotification("Order received and saved !");
        emailService.sendEmail(emailAddress, "Zapfhahn order",
                "Dear customer,\n \n" +
                        "Thank you for your order with Zapfhahn.\n \n" +
                        "We are pleased to confirm that your order for " + order.getQuantity() + " units of " +
                        order.getBeerName() + " has been carefully prepared and is ready for collection. \n \n" +
                        "Warm regards, \n \nAlessio from Zapfhahn.");
        System.out.println("Notification sent for order: " + order.getId());
    }
}