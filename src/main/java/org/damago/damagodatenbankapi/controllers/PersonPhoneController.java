package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.personPhone.*;
import org.damago.damagodatenbankapi.responses.PersonPhoneResponse;
import org.damago.damagodatenbankapi.services.PersonPhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/person-phone")
@Transactional
@Tag(name = "Person - Phone")
public class PersonPhoneController {
    private final PersonPhoneService personPhoneService;

    public PersonPhoneController(PersonPhoneService personPhoneService) {
        this.personPhoneService = personPhoneService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonPhoneRequest request = new DeletePersonPhoneRequest();

        request.setId(id);
        personPhoneService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonPhoneResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonPhoneResponse> result = personPhoneService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonPhoneResponse> GetById(@PathVariable String id) {
        GetPersonPhoneRequest request = new GetPersonPhoneRequest();

        request.setId(id);

        PersonPhoneResponse result = personPhoneService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonPhoneResponse> Post(@RequestBody AddPersonPhoneRequest request) {
        PersonPhoneResponse result = personPhoneService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonPhoneResponse> Put(@PathVariable String id, @RequestBody EditPersonPhoneRequest request) {
        request.setId(id);
        PersonPhoneResponse result = personPhoneService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonPhoneResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchPersonPhoneRequest request = new SearchPersonPhoneRequest();

        // request.setName(name);

        Iterable<PersonPhoneResponse> result = personPhoneService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
