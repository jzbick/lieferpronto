package com.lieferpronto.lieferpronto.order.models;

import com.lieferpronto.lieferpronto.address.models.Address;
import com.lieferpronto.lieferpronto.customer.models.Customer;
import com.lieferpronto.lieferpronto.deliveryman.models.Deliveryman;
import com.lieferpronto.lieferpronto.dish.models.Dish;
import com.lieferpronto.lieferpronto.restaurant.models.Restaurant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "`order`")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    private OrderStatus status;
    private Date orderDate;
    private Date deliveryDate;
    private PaymentMethod paymentMethod;
    @ManyToMany
    private List<Dish> dishes;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Deliveryman deliveryman;
    @OneToOne
    private Address address;

}
