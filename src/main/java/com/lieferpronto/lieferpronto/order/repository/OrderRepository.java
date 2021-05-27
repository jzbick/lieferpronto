package com.lieferpronto.lieferpronto.order.repository;

import com.lieferpronto.lieferpronto.order.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {

}
