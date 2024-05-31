package ch.hearc.jeespring.comi.notificationservice.controller;

import ch.hearc.jeespring.comi.notificationservice.model.Notification;
import ch.hearc.jeespring.comi.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @PostMapping
    public Notification createNotification(@RequestParam String message) {
        return notificationService.createNotification(message);
    }
}
