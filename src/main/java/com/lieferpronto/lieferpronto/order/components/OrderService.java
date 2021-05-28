package com.lieferpronto.lieferpronto.order.components;

import com.lieferpronto.lieferpronto.order.models.Order;
import com.lieferpronto.lieferpronto.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {

    private OrderRepository orderRepository;

    public List<Order> findAll() {

        var orders = new ArrayList<Order>();
        orderRepository.findAll().forEach(orders::add);

        return orders;
    }

    public ResponseEntity<Order> createOrder(Order order) {
        orderRepository.save(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
