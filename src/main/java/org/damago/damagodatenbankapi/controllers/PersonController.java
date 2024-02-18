package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.OpenAPI31;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.repositories.PersonRepository;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.DeletePersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.requests.person.GetPersonRequest;
import org.damago.damagodatenbankapi.responses.PersonResponse;
import org.damago.damagodatenbankapi.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

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

    /*
    * Delete Pfad mit defaultValue (soft delete)    -> http://localhost:8080/damago/api/v1/personen/{id}
    * Delete Pfad mit soft delete                   -> http://localhost:8080/damago/api/v1/personen/{id}?permanent=false
    * Delete Pfad mit hard delete                   -> http://localhost:8080/damago/api/v1/personen/{id}?permanent=true
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonRequest request = new DeletePersonRequest();
        request.setId(id);
        personService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /*
    * Get Pfad mit defaultValue (nur nicht gelöschte)   -> http://localhost:8080/damago/api/v1/personen
    * Get Pfad nur nicht gelöschte                      -> http://localhost:8080/damago/api/v1/personen?deleted=false
    * Get Pfad nur gelöschte                            -> http://localhost:8080/damago/api/v1/personen?deleted=true
    */
    @GetMapping
    public ResponseEntity<Iterable<PersonResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonResponse> result = personService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // Get Pfad einzelne Person anzeigen -> http://localhost:8080/damago/api/v1/personen/{id}
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

    // Post Pfad einzelne Person hinzufügen -> http://localhost:8080/damago/api/v1/personen
    @PostMapping
    public ResponseEntity<PersonResponse> Post(@RequestBody AddPersonRequest request) {
        PersonResponse result = personService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // Put Pfad einzelne Person aktualisieren -> http://localhost:8080/damago/api/v1/personen/{id}
    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> Put(@PathVariable String id, @RequestBody EditPersonRequest request) {
        request.setId(id);
        PersonResponse result = personService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /*
    * Get Pfad Personensuche -> http://localhost:8080/damago/api/v1/personen/search?nachname=test&vorname=test&geburtsdatum=2000/01/01
    * Jeder Parameter ist optional
    */
    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonResponse>> Search(
            @RequestParam(required = false, value = "nachname") String nachname,
            @RequestParam(required = false, value = "vorname") String vorname,
            @RequestParam(required = false, value = "geburtsdatum") Date geburtsdatum) {
        Iterable<PersonResponse> result = personService.Search(nachname, vorname, geburtsdatum);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
