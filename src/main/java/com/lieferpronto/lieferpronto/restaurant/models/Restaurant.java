package com.lieferpronto.lieferpronto.restaurant.models;

import com.lieferpronto.lieferpronto.address.models.Address;
import com.lieferpronto.lieferpronto.dish.models.Dish;
import com.lieferpronto.lieferpronto.order.models.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Restaurant {

    @Id
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    private String name;
    private String email;
    private String password;
    private Double minOrderValue;
    private Double deliveryCosts;
    //private Map<String, LocalTime[][]> openingHours;
    @OneToOne
    private Address address;
    @OneToMany
    private List<Order> orders;
    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishes;

}
