package org.damago.damagodatenbankapi.controllers;

import org.damago.damagodatenbankapi.entities.Rolle;
import org.damago.damagodatenbankapi.repositories.RolleRepository;
import org.damago.damagodatenbankapi.requests.rolle.AddRolleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/damago/api/v1/rollen")
public class RolleController {
    private final RolleRepository rolleRepository;

    public RolleController(RolleRepository rolleRepository) {
        this.rolleRepository = rolleRepository;
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Iterable<Rolle>> Get() {
        Iterable<Rolle> response = rolleRepository.sp_Roles_Get();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional<Rolle>> Get(@PathVariable String id) {
        Optional<Rolle> response = rolleRepository.sp_Roles_GetById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search/name/{name}")
    @Transactional
    public ResponseEntity<Iterable<Rolle>> GetByName(@PathVariable String name) {
        Iterable<Rolle> response = rolleRepository.sp_Roles_GetByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rolle> Post(@RequestBody AddRolleRequest request) {
        Rolle response = rolleRepository.sp_Roles_Add(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
