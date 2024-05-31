package ch.hearc.jeespring.comi.orderservice.service;

import ch.hearc.jeespring.comi.orderservice.model.Order;
import ch.hearc.jeespring.comi.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(String beerName, int quantity) {
        Order order = new Order(beerName, quantity);
        Order savedOrder = orderRepository.save(order);
        jmsTemplate.convertAndSend("order.queue", savedOrder);
        return savedOrder;
    }
}


