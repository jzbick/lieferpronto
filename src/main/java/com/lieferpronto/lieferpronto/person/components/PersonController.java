package com.lieferpronto.lieferpronto.person.components;

import com.lieferpronto.lieferpronto.person.models.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
        Optional<Person> person = personService.findById(UUID.fromString(id));
        if (person.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdatePerson(@RequestBody Person person) {
        return new ResponseEntity<>(String.format("Successfully updated or created person with id: %s",
            personService.savePerson(person).getId()),
            HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable UUID id) {
        Optional<Person> personOptional = personService.findById(id);

        if (personOptional.isEmpty()) {
            return new ResponseEntity<>(String.format("Person with id: %s doesn't exist", id), HttpStatus.NOT_FOUND);
        }
        personService.deletePerson(personOptional.get());
        return new ResponseEntity<>(String.format("Successfully deleted person with id: %s", personOptional.get().getId()), HttpStatus.OK);
    }
}
