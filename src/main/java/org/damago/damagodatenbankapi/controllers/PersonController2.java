package org.damago.damagodatenbankapi.controllers;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.entities.Person2;
import org.damago.damagodatenbankapi.repositories.Person2Repository;
import org.damago.damagodatenbankapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/damago/api/v2/adressen")
public class PersonController2 {
    @Autowired
    Person2Repository personRepository;

    @GetMapping
    public ResponseEntity<Iterable<Person2>> Get() {
        Iterable<Person2> personen = personRepository.findAll();
        return new ResponseEntity<>(personen, HttpStatus.OK);
    }
}
