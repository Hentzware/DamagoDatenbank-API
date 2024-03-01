package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.personAddress.*;
import org.damago.damagodatenbankapi.responses.PersonAddressResponse;
import org.damago.damagodatenbankapi.services.PersonAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/person-address")
@Transactional
@Tag(name = "Person - Address")
public class PersonAddressController {
    private final PersonAddressService personAddressService;

    public PersonAddressController(PersonAddressService personAddressService) {
        this.personAddressService = personAddressService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonAddressRequest request = new DeletePersonAddressRequest();

        request.setId(id);
        personAddressService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonAddressResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonAddressResponse> result = personAddressService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonAddressResponse> GetById(@PathVariable String id) {
        GetPersonAddressRequest request = new GetPersonAddressRequest();

        request.setId(id);

        PersonAddressResponse result = personAddressService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonAddressResponse> Post(@RequestBody AddPersonAddressRequest request) {
        PersonAddressResponse result = personAddressService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonAddressResponse> Put(@PathVariable String id, @RequestBody EditPersonAddressRequest request) {
        request.setId(id);
        PersonAddressResponse result = personAddressService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonAddressResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchPersonAddressRequest request = new SearchPersonAddressRequest();

        // request.setName(name);

        Iterable<PersonAddressResponse> result = personAddressService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
