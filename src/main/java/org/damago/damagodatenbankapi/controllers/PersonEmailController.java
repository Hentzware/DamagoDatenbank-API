package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.personEmail.*;
import org.damago.damagodatenbankapi.responses.PersonEmailResponse;
import org.damago.damagodatenbankapi.services.PersonEmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/personEmail")
@Transactional
@Tag(name = "Person - Email")
public class PersonEmailController {
    private final PersonEmailService personEmailService;

    public PersonEmailController(PersonEmailService personEmailService) {
        this.personEmailService = personEmailService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePersonEmailRequest request = new DeletePersonEmailRequest();
        request.setId(id);
        personEmailService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonEmailResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PersonEmailResponse> result = personEmailService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonEmailResponse> GetById(@PathVariable String id) {
        GetPersonEmailRequest request = new GetPersonEmailRequest();
        request.setId(id);
        PersonEmailResponse result = personEmailService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonEmailResponse> Post(@RequestBody AddPersonEmailRequest request) {
        PersonEmailResponse result = personEmailService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonEmailResponse> Put(@PathVariable String id, @RequestBody EditPersonEmailRequest request) {
        request.setId(id);
        PersonEmailResponse result = personEmailService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PersonEmailResponse>> Search(
            @RequestParam(required = false, value = "personId") String personId,
            @RequestParam(required = false, value = "emailId") String emailId) {
        SearchPersonEmailRequest request = new SearchPersonEmailRequest();
        request.setPersonId(personId);
        request.setEmailId(emailId);
        Iterable<PersonEmailResponse> result = personEmailService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
