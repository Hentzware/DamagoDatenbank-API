package org.damago.damagodatenbankapi.controllers;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.repositories.PersonRepository;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
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
    public ResponseEntity<Iterable<Person>> GetAll() {
        Iterable<Person> result = personRepository.sp_Persons_Get();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/deleted")
    @Transactional
    public ResponseEntity<Iterable<Person>> GetAllDeleted() {
        Iterable<Person> result = personRepository.sp_Persons_GetDeleted();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> GetById(@PathVariable String id) {
        Person result = personRepository.sp_Persons_GetById(id);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Person> Post(@RequestBody AddPersonRequest request) {
        String id = personRepository.sp_Persons_Add(request.getNachname(), request.getVorname(), request.getGeburtsdatum());
        Person result = personRepository.sp_Persons_GetById(id);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Person> Put(EditPersonRequest request) {
        personRepository.sp_Persons_Update(request.getId(), request.getNachname(), request.getVorname(), request.getGeburtsdatum());
        Person result = personRepository.sp_Persons_GetById(request.getId());
        return new ResponseEntity<>(result, HttpStatus.OK);
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
