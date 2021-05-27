package com.lieferpronto.lieferpronto.deliveryman.repository;

import com.lieferpronto.lieferpronto.deliveryman.models.Deliveryman;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeliverymanRepository extends CrudRepository<Deliveryman, UUID> {

}
