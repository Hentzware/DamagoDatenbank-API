package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.email.*;
import org.damago.damagodatenbankapi.requests.personAdresse.*;
import org.damago.damagodatenbankapi.responses.EmailResponse;
import org.damago.damagodatenbankapi.responses.PersonAdresseResponse;
import org.damago.damagodatenbankapi.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/emails")
@Transactional
@Tag(name = "Email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteEmailRequest request = new DeleteEmailRequest();
        request.setId(id);
        emailService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<EmailResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<EmailResponse> result = emailService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailResponse> GetById(@PathVariable String id) {
        GetEmailRequest request = new GetEmailRequest();
        request.setId(id);
        EmailResponse result = emailService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmailResponse> Post(@RequestBody AddEmailRequest request) {
        EmailResponse result = emailService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailResponse> Put(@PathVariable String id, @RequestBody EditEmailRequest request) {
        request.setId(id);
        EmailResponse result = emailService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<EmailResponse>> Search(
            @RequestParam(required = false, value = "email") String email) {
        SearchEmailRequest request = new SearchEmailRequest();
        request.setEmail(email);
        Iterable<EmailResponse> result = emailService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
