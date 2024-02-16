package org.damago.damagodatenbankapi.controllers;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.repositories.PersonRepository;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/damago/api/v1/personen")
public class PersonController {
    PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Iterable<Person>> Get() {
        Iterable<Person> result = personRepository.sp_Persons_Get();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Optional<Person>> Post(@RequestBody AddPersonRequest request) {
        personRepository.sp_Persons_Add(request.getNachname(), request.getVorname(), request.getGeburtsdatum());
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional<Person>> Delete(@PathVariable String id) {
        personRepository.sp_Persons_Delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    @Transactional
    public ResponseEntity<Iterable<Person>> GetByNachname(@RequestParam String nachname) {
        Iterable<Person> persons = personRepository.sp_Persons_GetByNachname(nachname);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
