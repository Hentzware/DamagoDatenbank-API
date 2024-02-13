package org.damago.damagodatenbankapi.controllers;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/damago/api/v1/personen")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public Iterable<Person> Get() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> Get(@PathVariable String id) {
        return personRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> Post(@RequestBody Person person) {
        Person result = personRepository.save(person);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person updatedPerson) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if(optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();
            existingPerson.setGeburtsdatum(updatedPerson.getGeburtsdatum());
            //existingPerson.setAdresse(updatedPerson.getAdresse());
            //existingPerson.setKontakt(updatedPerson.getKontakt());
            existingPerson.setNachname(updatedPerson.getNachname());
            existingPerson.setVorname(updatedPerson.getVorname());
            //existingPerson.setRolle(updatedPerson.getRolle());
            //existingPerson.setStandort(updatedPerson.getStandort());
            Person savedPerson = personRepository.save(existingPerson);
            return new ResponseEntity<>(savedPerson, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
