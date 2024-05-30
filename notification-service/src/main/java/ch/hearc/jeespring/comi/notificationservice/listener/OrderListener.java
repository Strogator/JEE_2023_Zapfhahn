package ch.hearc.jeespring.comi.notificationservice.listener;

import ch.hearc.jeespring.comi.notificationservice.model.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @JmsListener(destination = "order.queue")
    public void receiveOrder(Order order) {
        System.out.println("Received order: " + order);
        // Implementer la logique de notification
        sendNotification(order);
    }

    private void sendNotification(Order order) {
        // Logique pour envoyer une notification (par exemple, un email ou un SMS)
        System.out.println("Notification sent for order: " + order.getId());
    }
}
