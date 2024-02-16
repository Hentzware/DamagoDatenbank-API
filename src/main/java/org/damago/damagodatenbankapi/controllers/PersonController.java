package org.damago.damagodatenbankapi.controllers;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.repositories.PersonRepository;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public ResponseEntity<Iterable<Person>> GetBySearch(
            @RequestParam(required = false, value = "nachname") String nachname,
            @RequestParam(required = false, value = "vorname") String vorname,
            @RequestParam(required = false, value = "geburtsdatum") Date geburtsdatum) {
        List<Person> persons = new ArrayList<>();

        if (nachname != null) {
            persons.addAll(personRepository.sp_Persons_GetByNachname(nachname));
        }

        if (vorname != null) {
            persons.addAll(personRepository.sp_Persons_GetByVorname(vorname));
        }

        if (geburtsdatum != null) {
            persons.addAll(personRepository.sp_Persons_GetByGeburtsdatum(geburtsdatum));
        }

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
