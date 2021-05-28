package com.lieferpronto.lieferpronto.dish.repository;


import com.lieferpronto.lieferpronto.dish.models.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishRepository extends CrudRepository<Dish, UUID> {

}
