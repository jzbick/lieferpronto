package com.lieferpronto.lieferpronto.dish.models;

import com.lieferpronto.lieferpronto.order.models.Order;
import com.lieferpronto.lieferpronto.restaurant.models.Restaurant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Dish {

    @Id
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    private String name;
    private Double price;
    @ManyToMany(mappedBy = "dishes")
    private List<Order> orders;
    @ManyToOne
    private Restaurant restaurant;

}
