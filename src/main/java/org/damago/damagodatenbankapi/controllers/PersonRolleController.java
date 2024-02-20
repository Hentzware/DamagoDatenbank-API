package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.personRolle.*;
import org.damago.damagodatenbankapi.responses.PersonRolleResponse;
import org.damago.damagodatenbankapi.services.PersonRolleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/person-rolle")
@Transactional
@Tag(name = "Person - Rolle")
public class PersonRolleController {
    private final PersonRolleService personRolleService;

    public PersonRolleController(PersonRolleService personRolleService) {
        this.personRolleService = personRolleService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonRolleRequest request = new DeletePersonRolleRequest();
        request.setId(id);
        personRolleService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonRolleResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonRolleResponse> result = personRolleService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonRolleResponse> GetById(@PathVariable String id) {
        GetPersonRolleRequest request = new GetPersonRolleRequest();
        request.setId(id);
        PersonRolleResponse result = personRolleService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonRolleResponse> Post(@RequestBody AddPersonRolleRequest request) {
        PersonRolleResponse result = personRolleService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonRolleResponse> Put(@PathVariable String id, @RequestBody EditPersonRolleRequest request) {
        request.setId(id);
        PersonRolleResponse result = personRolleService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonRolleResponse>> Search(
            @RequestParam(required = false, value = "person_id") String person_id,
            @RequestParam(required = false, value = "rolle_id") String rolle_id) {
        SearchPersonRolleRequest request = new SearchPersonRolleRequest();
        request.setPerson_id(person_id);
        request.setRolle_id(rolle_id);
        Iterable<PersonRolleResponse> result = personRolleService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
