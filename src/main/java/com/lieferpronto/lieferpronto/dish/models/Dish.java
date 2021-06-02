package com.lieferpronto.lieferpronto.dish.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

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

}
