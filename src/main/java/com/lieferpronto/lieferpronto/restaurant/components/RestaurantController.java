package com.lieferpronto.lieferpronto.restaurant.components;

import com.lieferpronto.lieferpronto.restaurant.models.Restaurant;
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
@RequestMapping("/resturants")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String id) {
        Optional<Restaurant> restaurant = restaurantService.findById(UUID.fromString(id));
        if (restaurant.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(restaurant.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdateRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(String.format("Successfully updated or created restaurant with id: %s",
            restaurantService.saveRestaurant(restaurant).getId()),
            HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable UUID id) {
        Optional<Restaurant> restaurantOptional = restaurantService.findById(id);

        if (restaurantOptional.isEmpty()) {
            return new ResponseEntity<>(String.format("Restaurant with id: %s doesn't exist", id), HttpStatus.NOT_FOUND);
        }
        restaurantService.deleteRestaurant(restaurantOptional.get());
        return new ResponseEntity<>(String.format("Successfully deleted restaurant with id: %s", restaurantOptional.get().getId()), HttpStatus.OK);
    }
}
