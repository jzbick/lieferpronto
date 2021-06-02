package com.lieferpronto.lieferpronto.dish.components;

import com.lieferpronto.lieferpronto.dish.models.Dish;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class DishController {

    private final DishService dishService;

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable String id) {
        Optional<Dish> dish = dishService.findById(UUID.fromString(id));
        if (dish.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(dish.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getDishes() {
        return new ResponseEntity<>(dishService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdateDish(@RequestBody Dish dish) {
        return new ResponseEntity<>(String.format("Successfully updated or created dish with id: %s",
            dishService.saveDish(dish).getId()),
            HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable UUID id) {
        Optional<Dish> dishOptional = dishService.findById(id);

        if (dishOptional.isEmpty()) {
            return new ResponseEntity<>(String.format("Dish with id: %s doesn't exist", id), HttpStatus.NOT_FOUND);
        }
        dishService.deleteDish(dishOptional.get());
        return new ResponseEntity<>(String.format("Successfully deleted dish with id: %s", dishOptional.get().getId()), HttpStatus.OK);
    }
}
