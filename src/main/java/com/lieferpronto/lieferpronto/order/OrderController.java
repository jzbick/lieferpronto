package com.lieferpronto.lieferpronto.order;

import com.lieferpronto.lieferpronto.order.components.OrderService;
import com.lieferpronto.lieferpronto.order.models.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @GetMapping
    public List<Order> getOrders() {
        return orderService.findAll();
    }

    //    @GetMapping("/{id}")
//    public Order getOrderById(@PathVariable UUID id) {
//        return orderRepository.findById(id).orElse(new Order());
//    }
//
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
}
