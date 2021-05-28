package com.lieferpronto.lieferpronto.person.components;

import com.lieferpronto.lieferpronto.person.models.Person;
import com.lieferpronto.lieferpronto.person.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    public List<Person> findAll() {

        var persons = new ArrayList<Person>();
        personRepository.findAll().forEach(persons::add);

        return persons;
    }

    public ResponseEntity<Person> createOrder(Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
