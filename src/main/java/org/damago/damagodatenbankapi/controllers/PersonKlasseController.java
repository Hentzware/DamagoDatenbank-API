package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.personKlasse.*;
import org.damago.damagodatenbankapi.responses.PersonKlasseResponse;
import org.damago.damagodatenbankapi.services.PersonKlasseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/personKlasse")
@Transactional
@Tag(name = "Person - Klasse")
public class PersonKlasseController {
    private final PersonKlasseService personKlasseService;

    public PersonKlasseController(PersonKlasseService personKlasseService) {
        this.personKlasseService = personKlasseService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonKlasseRequest request = new DeletePersonKlasseRequest();
        request.setId(id);
        personKlasseService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonKlasseResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonKlasseResponse> result = personKlasseService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonKlasseResponse> GetById(@PathVariable String id) {
        GetPersonKlasseRequest request = new GetPersonKlasseRequest();
        request.setId(id);
        PersonKlasseResponse result = personKlasseService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonKlasseResponse> Post(@RequestBody AddPersonKlasseRequest request) {
        PersonKlasseResponse result = personKlasseService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonKlasseResponse> Put(@PathVariable String id, @RequestBody EditPersonKlasseRequest request) {
        request.setId(id);
        PersonKlasseResponse result = personKlasseService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonKlasseResponse>> Search(
            @RequestParam(required = false, value = "personId") String personId,
            @RequestParam(required = false, value = "klasseId") String klasseId) {
        SearchPersonKlasseRequest request = new SearchPersonKlasseRequest();
        request.setPersonId(personId);
        request.setKlasseId(klasseId);
        Iterable<PersonKlasseResponse> result = personKlasseService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
