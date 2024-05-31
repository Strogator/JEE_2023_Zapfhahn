package ch.hearc.jeespring.comi.notificationservice.repository;

import ch.hearc.jeespring.comi.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
