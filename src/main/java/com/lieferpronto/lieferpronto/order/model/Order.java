package com.lieferpronto.lieferpronto.order.model;

import lombok.ToString;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue
    @ToString.Include
    private UUID id;
    private Date orderDate;
    private Date deliveryDate;
}
