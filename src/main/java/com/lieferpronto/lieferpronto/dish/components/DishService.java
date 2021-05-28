package com.lieferpronto.lieferpronto.dish.components;

import com.lieferpronto.lieferpronto.dish.models.Dish;
import com.lieferpronto.lieferpronto.dish.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DishService {

    private DishRepository dishRepository;

    public List<Dish> findAll() {

        var Dishes = new ArrayList<Dish>();
        dishRepository.findAll().forEach(Dishes::add);

        return Dishes;
    }

    public ResponseEntity<Dish> createOrder(Dish dish) {
        dishRepository.save(dish);
        return new ResponseEntity<>(dish, HttpStatus.CREATED);
    }
}
