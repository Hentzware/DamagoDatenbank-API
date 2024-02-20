package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.personTelefonnummer.*;
import org.damago.damagodatenbankapi.responses.PersonTelefonnummerResponse;
import org.damago.damagodatenbankapi.services.PersonTelefonnummerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/person-telefonnummer")
@Transactional
@Tag(name = "Person - Telefonnummer")
public class PersonTelefonnummerController {
    private final PersonTelefonnummerService personTelefonnummerService;

    public PersonTelefonnummerController(PersonTelefonnummerService personTelefonnummerService) {
        this.personTelefonnummerService = personTelefonnummerService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonTelefonnummerRequest request = new DeletePersonTelefonnummerRequest();
        request.setId(id);
        personTelefonnummerService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonTelefonnummerResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonTelefonnummerResponse> result = personTelefonnummerService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonTelefonnummerResponse> GetById(@PathVariable String id) {
        GetPersonTelefonnummerRequest request = new GetPersonTelefonnummerRequest();
        request.setId(id);
        PersonTelefonnummerResponse result = personTelefonnummerService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonTelefonnummerResponse> Post(@RequestBody AddPersonTelefonnummerRequest request) {
        PersonTelefonnummerResponse result = personTelefonnummerService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonTelefonnummerResponse> Put(@PathVariable String id, @RequestBody EditPersonTelefonnummerRequest request) {
        request.setId(id);
        PersonTelefonnummerResponse result = personTelefonnummerService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonTelefonnummerResponse>> Search(
            @RequestParam(required = false, value = "person_id") String person_id,
            @RequestParam(required = false, value = "telefonnummer_id") String telefonnummer_id) {
        SearchPersonTelefonnummerRequest request = new SearchPersonTelefonnummerRequest();
        request.setPerson_id(person_id);
        request.setTelefonnummer_id(telefonnummer_id);
        Iterable<PersonTelefonnummerResponse> result = personTelefonnummerService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
