package com.lieferpronto.lieferpronto.dish.components;

import com.lieferpronto.lieferpronto.dish.models.Dish;
import com.lieferpronto.lieferpronto.dish.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DishService {

    private DishRepository dishRepository;

    public Optional<Dish> findById(UUID id) {
        return dishRepository.findById(id);
    }

    public List<Dish> findAll() {
        var Dishes = new ArrayList<Dish>();
        dishRepository.findAll().forEach(Dishes::add);
        return Dishes;
    }

    public Dish saveDish(Dish dish) {
        dishRepository.save(dish);
        return dish;
    }

    public void deleteDish(Dish dish) {
        dishRepository.deleteById(dish.getId());
    }
}
