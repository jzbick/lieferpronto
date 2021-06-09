package com.lieferpronto.lieferpronto.address.models;

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
public class Address {

    @Id
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    private String street;
    private String zip;
    private String city;
}
