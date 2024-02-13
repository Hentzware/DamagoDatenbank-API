package org.damago.damagodatenbankapi.controllers;

import org.damago.damagodatenbankapi.entities.Adresse;
import org.damago.damagodatenbankapi.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/damago/api/v1/adressen")
public class AdresseController {
    @Autowired
    AdresseRepository adresseRepository;

    @GetMapping
    public Iterable<Adresse> Get() {
        return adresseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Adresse>> Get(@RequestAttribute String id) {
        Optional<Adresse> adresse = adresseRepository.findById(id);

        if (adresse.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(adresse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Adresse> Post(@RequestBody Adresse adresse) {
        Adresse result = adresseRepository.save(adresse);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}