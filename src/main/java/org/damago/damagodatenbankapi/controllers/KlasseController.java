package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.klasse.*;
import org.damago.damagodatenbankapi.responses.KlasseResponse;
import org.damago.damagodatenbankapi.services.KlasseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/klassen")
@Transactional
@Tag(name = "Klassen")
public class KlasseController {
    private final KlasseService klasseService;

    public KlasseController(KlasseService klasseService) {
        this.klasseService = klasseService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteKlasseRequest request = new DeleteKlasseRequest();
        request.setId(id);
        klasseService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<KlasseResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<KlasseResponse> result = klasseService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KlasseResponse> GetById(@PathVariable String id) {
        GetKlasseRequest request = new GetKlasseRequest();
        request.setId(id);
        KlasseResponse result = klasseService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<KlasseResponse> Post(@RequestBody AddKlasseRequest request) {
        KlasseResponse result = klasseService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KlasseResponse> Put(@PathVariable String id, @RequestBody EditKlasseRequest request) {
        request.setId(id);
        KlasseResponse result = klasseService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<KlasseResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {
        SearchKlasseRequest request = new SearchKlasseRequest();
        request.setName(name);
        Iterable<KlasseResponse> result = klasseService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
