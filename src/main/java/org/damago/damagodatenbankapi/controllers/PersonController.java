package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.person.*;
import org.damago.damagodatenbankapi.responses.PersonResponse;
import org.damago.damagodatenbankapi.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/damago/api/v1/personen")
@Transactional
@OpenAPIDefinition(info = @Info(title = "Damago Datenbank", version = "v1"))
@Tag(name = "Personen")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonRequest request = new DeletePersonRequest();
        request.setId(id);
        personService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonResponse> result = personService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> GetById(@PathVariable String id) {
        GetPersonRequest request = new GetPersonRequest();
        request.setId(id);
        PersonResponse result = personService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonResponse> Post(@RequestBody AddPersonRequest request) {
        PersonResponse result = personService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> Put(@PathVariable String id, @RequestBody EditPersonRequest request) {
        request.setId(id);
        PersonResponse result = personService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonResponse>> Search(
            @RequestParam(required = false, value = "nachname") String nachname,
            @RequestParam(required = false, value = "vorname") String vorname,
            @RequestParam(required = false, value = "geburtsdatum") Date geburtsdatum) {
        SearchPersonRequest request = new SearchPersonRequest();
        request.setNachname(nachname);
        request.setVorname(vorname);
        request.setGeburtsdatum(geburtsdatum);
        Iterable<PersonResponse> result = personService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
