package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.personRolle.*;
import org.damago.damagodatenbankapi.requests.personStandort.*;
import org.damago.damagodatenbankapi.responses.PersonRolleResponse;
import org.damago.damagodatenbankapi.responses.PersonStandortResponse;
import org.damago.damagodatenbankapi.services.PersonRolleService;
import org.damago.damagodatenbankapi.services.PersonStandortService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/person-standort")
@Transactional
@Tag(name = "Person - Standort")
public class PersonStandortController {
    private final PersonStandortService personStandortService;

    public PersonStandortController(PersonStandortService personStandortService) {
        this.personStandortService = personStandortService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonStandortRequest request = new DeletePersonStandortRequest();
        request.setId(id);
        personStandortService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonStandortResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonStandortResponse> result = personStandortService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonStandortResponse> GetById(@PathVariable String id) {
        GetPersonStandortRequest request = new GetPersonStandortRequest();
        request.setId(id);
        PersonStandortResponse result = personStandortService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonStandortResponse> Post(@RequestBody AddPersonStandortRequest request) {
        PersonStandortResponse result = personStandortService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonStandortResponse> Put(@PathVariable String id, @RequestBody EditPersonStandortRequest request) {
        request.setId(id);
        PersonStandortResponse result = personStandortService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonStandortResponse>> Search(
            @RequestParam(required = false, value = "person_id") String person_id,
            @RequestParam(required = false, value = "standort_id") String standort_id) {
        SearchPersonStandortRequest request = new SearchPersonStandortRequest();
        request.setPerson_id(person_id);
        request.setStandort_id(standort_id);
        Iterable<PersonStandortResponse> result = personStandortService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
