package ch.hearc.jeespring.comi.notificationservice.service;

import ch.hearc.jeespring.comi.notificationservice.model.Notification;
import ch.hearc.jeespring.comi.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification createNotification(String message) {
        return notificationRepository.save(new Notification(message));
    }
}
