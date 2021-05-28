package com.lieferpronto.lieferpronto.person.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    @Id
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    private String phoneNumber;
    private String email;
    private String password;
}
