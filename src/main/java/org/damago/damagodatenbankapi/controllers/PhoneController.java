package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.phone.*;
import org.damago.damagodatenbankapi.responses.PhoneResponse;
import org.damago.damagodatenbankapi.services.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/phone")
@Transactional
@Tag(name = "Phone")
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeletePhoneRequest request = new DeletePhoneRequest();

        request.setId(id);
        phoneService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<PhoneResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<PhoneResponse> result = phoneService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneResponse> GetById(@PathVariable String id) {
        GetPhoneRequest request = new GetPhoneRequest();

        request.setId(id);

        PhoneResponse result = phoneService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PhoneResponse> Post(@RequestBody AddPhoneRequest request) {
        PhoneResponse result = phoneService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneResponse> Put(@PathVariable String id, @RequestBody EditPhoneRequest request) {
        request.setId(id);
        PhoneResponse result = phoneService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<PhoneResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchPhoneRequest request = new SearchPhoneRequest();

        // request.setName(name);

        Iterable<PhoneResponse> result = phoneService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
