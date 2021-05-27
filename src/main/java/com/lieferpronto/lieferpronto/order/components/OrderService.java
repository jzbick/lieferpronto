package com.lieferpronto.lieferpronto.order.components;

import com.lieferpronto.lieferpronto.order.models.Order;
import com.lieferpronto.lieferpronto.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {

    private final OrderRepository orderRepository;

    public Optional<Order> findById(UUID id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAll() {
        var orders = new ArrayList<Order>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    public Order saveOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    public void deleteOrder(Order order) {
        orderRepository.deleteById(order.getId());
    }

}
