package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.raum.*;
import org.damago.damagodatenbankapi.responses.RaumResponse;
import org.damago.damagodatenbankapi.services.RaumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/raeume")
@Transactional
@Tag(name = "Raeume")
public class RaumController {
    private final RaumService raumService;

    public RaumController(RaumService raumService) {
        this.raumService = raumService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteRaumRequest request = new DeleteRaumRequest();
        request.setId(id);
        raumService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<RaumResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<RaumResponse> result = raumService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RaumResponse> GetById(@PathVariable String id) {
        GetRaumRequest request = new GetRaumRequest();
        request.setId(id);
        RaumResponse result = raumService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RaumResponse> Post(@RequestBody AddRaumRequest request) {
        RaumResponse result = raumService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RaumResponse> Put(@PathVariable String id, @RequestBody EditRaumRequest request) {
        request.setId(id);
        RaumResponse result = raumService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<RaumResponse>> Search(
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "nr") String nr) {
        SearchRaumRequest request = new SearchRaumRequest();
        request.setName(name);
        request.setNr(nr);
        Iterable<RaumResponse> result = raumService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
