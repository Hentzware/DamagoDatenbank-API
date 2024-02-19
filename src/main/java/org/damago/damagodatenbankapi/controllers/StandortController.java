package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.standort.*;
import org.damago.damagodatenbankapi.responses.StandortResponse;
import org.damago.damagodatenbankapi.services.StandortService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/standorte")
@Transactional
@Tag(name = "Standorte")
public class StandortController {
    private final StandortService standortService;

    public StandortController(StandortService standortService) {
        this.standortService = standortService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteStandortRequest request = new DeleteStandortRequest();
        request.setId(id);
        standortService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<StandortResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<StandortResponse> result = standortService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandortResponse> GetById(@PathVariable String id) {
        GetStandortRequest request = new GetStandortRequest();
        request.setId(id);
        StandortResponse result = standortService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StandortResponse> Post(@RequestBody AddStandortRequest request) {
        StandortResponse result = standortService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandortResponse> Put(@PathVariable String id, @RequestBody EditStandortRequest request) {
        request.setId(id);
        StandortResponse result = standortService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<StandortResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {
        SearchStandortRequest request = new SearchStandortRequest();
        request.setName(name);
        Iterable<StandortResponse> result = standortService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
