package ch.hearc.jeespring.comi.orderservice.service;

import ch.hearc.jeespring.comi.orderservice.model.Order;
import ch.hearc.jeespring.comi.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final JmsTemplate jmsTemplate;
    private final String orderQueue;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(JmsTemplate jmsTemplate, @Value("${order.queue.name}") String orderQueue, OrderRepository orderRepository) {
        this.jmsTemplate = jmsTemplate;
        this.orderQueue = orderQueue;
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        // Save the order to the database
        Order savedOrder = orderRepository.save(order);

        // Send a message to the order queue
        jmsTemplate.convertAndSend(orderQueue, savedOrder);

        return savedOrder;
    }
}
