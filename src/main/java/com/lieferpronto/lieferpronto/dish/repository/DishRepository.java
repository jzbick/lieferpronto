package com.lieferpronto.lieferpronto.dish.repository;

import com.lieferpronto.lieferpronto.dish.models.Dish;
import com.lieferpronto.lieferpronto.restaurant.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DishRepository extends CrudRepository<Dish, UUID> {

    List<Dish> findAllByRestaurant(Restaurant restaurant);
}
