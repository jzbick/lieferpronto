package com.lieferpronto.lieferpronto.restaurant.components;

import com.lieferpronto.lieferpronto.restaurant.models.Restaurant;
import com.lieferpronto.lieferpronto.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public List<Restaurant> findAll() {

        var restaurants = new ArrayList<Restaurant>();
        restaurantRepository.findAll().forEach(restaurants::add);

        return restaurants;
    }

    public ResponseEntity<Restaurant> createOrder(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
}
