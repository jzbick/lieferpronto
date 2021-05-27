package com.lieferpronto.lieferpronto.deliveryman.models;

import com.lieferpronto.lieferpronto.address.models.Address;
import com.lieferpronto.lieferpronto.order.models.Order;
import com.lieferpronto.lieferpronto.person.models.Person;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;


@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Deliveryman extends Person {
    private DeliveryMethod deliveryMethod;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "deliveryman")
    private List<Order> orders;
}
