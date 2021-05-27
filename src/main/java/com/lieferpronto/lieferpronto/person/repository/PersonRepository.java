package com.lieferpronto.lieferpronto.person.repository;

import com.lieferpronto.lieferpronto.person.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {

}
