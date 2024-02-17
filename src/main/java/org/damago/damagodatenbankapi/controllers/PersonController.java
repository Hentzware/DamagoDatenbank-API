package org.damago.damagodatenbankapi.controllers;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.repositories.PersonRepository;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/damago/api/v1/personen")
public class PersonController {
    final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional<Person>> Delete(
            @PathVariable String id,
            @RequestParam(required = false, defaultValue = "false") boolean permanent) {

        if (permanent) {
            personRepository.sp_Persons_DeletePermanent(id);
        } else {
            personRepository.sp_Persons_Delete(id);
        }

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Iterable<Person>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<Person> result;

        if (deleted) {
            result = personRepository.sp_Persons_GetDeleted();
        } else {
            result = personRepository.sp_Persons_Get();
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional<Person>> GetById(@PathVariable String id) {
        Optional<Person> result = personRepository.sp_Persons_GetById(id);

        if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Optional<Person>> Post(@RequestBody AddPersonRequest request) {
        String id = personRepository.sp_Persons_Add(request.getNachname(), request.getVorname(), request.getGeburtsdatum());
        Optional<Person> result = personRepository.sp_Persons_GetById(id);

        if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional<Person>> Put(EditPersonRequest request) {
        personRepository.sp_Persons_Update(request.getId(), request.getNachname(), request.getVorname(), request.getGeburtsdatum());
        Optional<Person> result = personRepository.sp_Persons_GetById(request.getId());

        if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    @Transactional
    public ResponseEntity<Iterable<Person>> Search(
            @RequestParam(required = false, value = "nachname") String nachname,
            @RequestParam(required = false, value = "vorname") String vorname,
            @RequestParam(required = false, value = "geburtsdatum") Date geburtsdatum) {
        Iterable<Person> result = personRepository.sp_Persons_Search(nachname, vorname, geburtsdatum);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
