package com.lieferpronto.lieferpronto.address.models;

import com.lieferpronto.lieferpronto.customer.models.Customer;
import com.lieferpronto.lieferpronto.deliveryman.models.Deliveryman;
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
import javax.persistence.OneToOne;
import java.util.List;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    @Id
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    private String street;
    private String plz;
    private String ort;
    @OneToOne(mappedBy = "address")
    private Deliveryman deliveryman;
    @OneToOne(mappedBy = "address")
    private Restaurant restaurant;
    @OneToOne(mappedBy = "address")
    private Order order;
    @ManyToMany(mappedBy = "addresses")
    private List<Customer> customers;
}
