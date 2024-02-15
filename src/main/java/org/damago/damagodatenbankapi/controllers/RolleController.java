package org.damago.damagodatenbankapi.controllers;

import org.damago.damagodatenbankapi.entities.Rolle;
import org.damago.damagodatenbankapi.repositories.RolleRepository;
import org.damago.damagodatenbankapi.requests.rolle.AddRolleRequest;
import org.damago.damagodatenbankapi.requests.rolle.GetRolleRequest;
import org.damago.damagodatenbankapi.responses.RolleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/damago/api/v2/rollen")
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


}
