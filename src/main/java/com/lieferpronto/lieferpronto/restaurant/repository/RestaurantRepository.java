package com.lieferpronto.lieferpronto.restaurant.repository;

import com.lieferpronto.lieferpronto.restaurant.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, UUID> {

}
