package com.lieferpronto.lieferpronto.order.components;

import com.lieferpronto.lieferpronto.order.models.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        Optional<Order> order = orderService.findById(UUID.fromString(id));
        if (order.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdateOrder(@RequestBody Order order) {
        return new ResponseEntity<>(String.format("Successfully updated or created order with id: %s",
            orderService.saveOrder(order).getId()),
            HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable UUID id) {
        Optional<Order> orderOptional = orderService.findById(id);

        if (orderOptional.isEmpty()) {
            return new ResponseEntity<>(String.format("Order with id: %s doesn't exist", id), HttpStatus.NOT_FOUND);
        }
        orderService.deleteOrder(orderOptional.get());
        return new ResponseEntity<>(String.format("Successfully deleted order with id: %s", orderOptional.get().getId()), HttpStatus.OK);
    }
}
