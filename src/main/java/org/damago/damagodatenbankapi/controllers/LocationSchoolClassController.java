package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.locationSchoolClass.*;
import org.damago.damagodatenbankapi.responses.LocationSchoolClassResponse;
import org.damago.damagodatenbankapi.services.LocationSchoolClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/locationSchoolClass")
@Transactional
@Tag(name = "LocationSchoolClass")
public class LocationSchoolClassController {
    private final LocationSchoolClassService locationSchoolClassService;

    public LocationSchoolClassController(LocationSchoolClassService locationSchoolClassService) {
        this.locationSchoolClassService = locationSchoolClassService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteLocationSchoolClassRequest request = new DeleteLocationSchoolClassRequest();

        request.setId(id);
        locationSchoolClassService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<LocationSchoolClassResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<LocationSchoolClassResponse> result = locationSchoolClassService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationSchoolClassResponse> GetById(@PathVariable String id) {
        GetLocationSchoolClassRequest request = new GetLocationSchoolClassRequest();

        request.setId(id);

        LocationSchoolClassResponse result = locationSchoolClassService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationSchoolClassResponse> Post(@RequestBody AddLocationSchoolClassRequest request) {
        LocationSchoolClassResponse result = locationSchoolClassService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationSchoolClassResponse> Put(@PathVariable String id, @RequestBody EditLocationSchoolClassRequest request) {
        request.setId(id);
        LocationSchoolClassResponse result = locationSchoolClassService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<LocationSchoolClassResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchLocationSchoolClassRequest request = new SearchLocationSchoolClassRequest();

        // request.setName(name);

        Iterable<LocationSchoolClassResponse> result = locationSchoolClassService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
