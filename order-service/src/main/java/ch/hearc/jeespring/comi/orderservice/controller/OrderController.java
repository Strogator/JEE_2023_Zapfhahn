package ch.hearc.jeespring.comi.orderservice.controller;

import ch.hearc.jeespring.comi.orderservice.model.Order;
import ch.hearc.jeespring.comi.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestParam String beerName, @RequestParam int quantity) {
        return orderService.createOrder(beerName, quantity);
    }
}