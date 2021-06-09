package com.lieferpronto.lieferpronto.restaurant.components;

import com.lieferpronto.lieferpronto.restaurant.models.Restaurant;
import com.lieferpronto.lieferpronto.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Optional<Restaurant> findById(UUID id) {
        return restaurantRepository.findById(id);
    }

    public List<Restaurant> findAll() {
        var restaurants = new ArrayList<Restaurant>();
        restaurantRepository.findAll().forEach(restaurants::add);
        return restaurants;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public void deleteRestaurant(Restaurant restaurant) {
        restaurantRepository.deleteById(restaurant.getId());
    }
}
