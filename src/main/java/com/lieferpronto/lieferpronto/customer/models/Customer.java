package com.lieferpronto.lieferpronto.customer.models;

import com.lieferpronto.lieferpronto.address.models.Address;
import com.lieferpronto.lieferpronto.order.models.Order;
import com.lieferpronto.lieferpronto.person.models.Person;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends Person {
    private String firstname;
    private String lastname;
    @ManyToMany
    private List<Address> addresses;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
