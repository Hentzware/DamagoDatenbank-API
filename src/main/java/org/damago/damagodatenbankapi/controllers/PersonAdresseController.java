package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.personAdresse.*;
import org.damago.damagodatenbankapi.responses.PersonAdresseResponse;
import org.damago.damagodatenbankapi.services.PersonAdresseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/personAdresse")
@Transactional
@Tag(name = "Person - Adresse")
public class PersonAdresseController {
    private final PersonAdresseService personAdresseService;

    public PersonAdresseController(PersonAdresseService personAdresseService) {
        this.personAdresseService = personAdresseService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonAdresseRequest request = new DeletePersonAdresseRequest();
        request.setId(id);
        personAdresseService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonAdresseResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonAdresseResponse> result = personAdresseService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonAdresseResponse> GetById(@PathVariable String id) {
        GetPersonAdresseRequest request = new GetPersonAdresseRequest();
        request.setId(id);
        PersonAdresseResponse result = personAdresseService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonAdresseResponse> Post(@RequestBody AddPersonAdresseRequest request) {
        PersonAdresseResponse result = personAdresseService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonAdresseResponse> Put(@PathVariable String id, @RequestBody EditPersonAdresseRequest request) {
        request.setId(id);
        PersonAdresseResponse result = personAdresseService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonAdresseResponse>> Search(
            @RequestParam(required = false, value = "personId") String personId,
            @RequestParam(required = false, value = "adresseId") String adresseId) {
        SearchPersonAdresseRequest request = new SearchPersonAdresseRequest();
        request.setPerson_id(personId);
        request.setAdresse_id(adresseId);
        Iterable<PersonAdresseResponse> result = personAdresseService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
