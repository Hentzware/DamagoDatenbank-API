package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.telefonnummer.*;
import org.damago.damagodatenbankapi.responses.TelefonnummerResponse;
import org.damago.damagodatenbankapi.services.TelefonnummerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/telefonnummern")
@Transactional
@Tag(name = "Telefonnummern")
public class TelefonnummerController {
    private final TelefonnummerService telefonnummerService;

    public TelefonnummerController(TelefonnummerService telefonnummerService) {
        this.telefonnummerService = telefonnummerService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteTelefonnummerRequest request = new DeleteTelefonnummerRequest();
        request.setId(id);
        telefonnummerService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<TelefonnummerResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<TelefonnummerResponse> result = telefonnummerService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefonnummerResponse> GetById(@PathVariable String id) {
        GetTelefonnummerRequest request = new GetTelefonnummerRequest();
        request.setId(id);
        TelefonnummerResponse result = telefonnummerService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TelefonnummerResponse> Post(@RequestBody AddTelefonnummerRequest request) {
        TelefonnummerResponse result = telefonnummerService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefonnummerResponse> Put(@PathVariable String id, @RequestBody EditTelefonnummerRequest request) {
        request.setId(id);
        TelefonnummerResponse result = telefonnummerService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<TelefonnummerResponse>> Search(
            @RequestParam(required = false, value = "telefonnummer") String telefonnummer) {
        SearchTelefonnummerRequest request = new SearchTelefonnummerRequest();
        request.setTelefonnummer(telefonnummer);
        Iterable<TelefonnummerResponse> result = telefonnummerService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
