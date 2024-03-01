package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.personSchoolClass.*;
import org.damago.damagodatenbankapi.responses.PersonSchoolClassResponse;
import org.damago.damagodatenbankapi.services.PersonSchoolClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/personSchoolClass")
@Transactional
@Tag(name = "PersonSchoolClass")
public class PersonSchoolClassController {
    private final PersonSchoolClassService personSchoolClassService;

    public PersonSchoolClassController(PersonSchoolClassService personSchoolClassService) {
        this.personSchoolClassService = personSchoolClassService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonSchoolClassRequest request = new DeletePersonSchoolClassRequest();

        request.setId(id);
        personSchoolClassService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonSchoolClassResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonSchoolClassResponse> result = personSchoolClassService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonSchoolClassResponse> GetById(@PathVariable String id) {
        GetPersonSchoolClassRequest request = new GetPersonSchoolClassRequest();

        request.setId(id);

        PersonSchoolClassResponse result = personSchoolClassService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonSchoolClassResponse> Post(@RequestBody AddPersonSchoolClassRequest request) {
        PersonSchoolClassResponse result = personSchoolClassService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonSchoolClassResponse> Put(@PathVariable String id, @RequestBody EditPersonSchoolClassRequest request) {
        request.setId(id);
        PersonSchoolClassResponse result = personSchoolClassService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonSchoolClassResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchPersonSchoolClassRequest request = new SearchPersonSchoolClassRequest();

        // request.setName(name);

        Iterable<PersonSchoolClassResponse> result = personSchoolClassService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
