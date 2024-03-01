package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.personRole.*;
import org.damago.damagodatenbankapi.responses.PersonRoleResponse;
import org.damago.damagodatenbankapi.services.PersonRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/person-role")
@Transactional
@Tag(name = "Person - Role")
public class PersonRoleController {
    private final PersonRoleService personRoleService;

    public PersonRoleController(PersonRoleService personRoleService) {
        this.personRoleService = personRoleService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonRoleRequest request = new DeletePersonRoleRequest();

        request.setId(id);
        personRoleService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonRoleResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonRoleResponse> result = personRoleService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonRoleResponse> GetById(@PathVariable String id) {
        GetPersonRoleRequest request = new GetPersonRoleRequest();

        request.setId(id);

        PersonRoleResponse result = personRoleService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonRoleResponse> Post(@RequestBody AddPersonRoleRequest request) {
        PersonRoleResponse result = personRoleService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonRoleResponse> Put(@PathVariable String id, @RequestBody EditPersonRoleRequest request) {
        request.setId(id);
        PersonRoleResponse result = personRoleService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonRoleResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchPersonRoleRequest request = new SearchPersonRoleRequest();

        // request.setName(name);

        Iterable<PersonRoleResponse> result = personRoleService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
