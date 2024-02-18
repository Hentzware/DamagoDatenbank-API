package org.damago.damagodatenbankapi.controllers;

import org.damago.damagodatenbankapi.requests.adresse.*;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.DeletePersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.requests.person.GetPersonRequest;
import org.damago.damagodatenbankapi.responses.AdresseResponse;
import org.damago.damagodatenbankapi.responses.PersonResponse;
import org.damago.damagodatenbankapi.services.AdresseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/damago/api/v1/adressen")
@Transactional
public class AdresseController {
    private final AdresseService adresseService;

    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteAdresseRequest request = new DeleteAdresseRequest();
        request.setId(id);
        adresseService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<AdresseResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<AdresseResponse> result = adresseService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdresseResponse> GetById(@PathVariable String id) {
        GetAdresseRequest request = new GetAdresseRequest();
        request.setId(id);
        AdresseResponse result = adresseService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AdresseResponse> Post(@RequestBody AddAdresseRequest request) {
        AdresseResponse result = adresseService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdresseResponse> Put(@PathVariable String id, @RequestBody EditAdresseRequest request) {
        request.setId(id);
        AdresseResponse result = adresseService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<AdresseResponse>> Search(
            @RequestParam(required = false, value = "strasse") String strasse,
            @RequestParam(required = false, value = "hausnummer") String hausnummer,
            @RequestParam(required = false, value = "postleitzahl") String postleitzahl,
            @RequestParam(required = false, value = "ort") String ort,
            @RequestParam(required = false, value = "land") String land) {
        SearchAdresseRequest request = new SearchAdresseRequest();
        request.setStrasse(strasse);
        request.setHausnummer(hausnummer);
        request.setPostleitzahl(postleitzahl);
        request.setOrt(ort);
        request.setLand(land);
        Iterable<AdresseResponse> result = adresseService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
