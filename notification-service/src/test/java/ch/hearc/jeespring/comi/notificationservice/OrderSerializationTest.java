package ch.hearc.jeespring.comi.notificationservice;

import ch.hearc.jeespring.comi.notificationservice.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderSerializationTest {

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Test
    public void testOrderSerialization() throws Exception {
        Order order = new Order(1L, "FRUH", 10);
        String json = objectMapper.writeValueAsString(order);
        System.out.println("Serialized order: " + json);

        Order deserializedOrder = objectMapper.readValue(json, Order.class);
        System.out.println("Deserialized order: " + deserializedOrder);

        assertEquals(order.getId(), deserializedOrder.getId());
        assertEquals(order.getBeerName(), deserializedOrder.getBeerName());
        assertEquals(order.getQuantity(), deserializedOrder.getQuantity());
    }
}
