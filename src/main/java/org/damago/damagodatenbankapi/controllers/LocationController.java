package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.location.*;
import org.damago.damagodatenbankapi.responses.LocationResponse;
import org.damago.damagodatenbankapi.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/locations")
@Transactional
@Tag(name = "Locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteLocationRequest request = new DeleteLocationRequest();
        request.setId(id);
        locationService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<LocationResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<LocationResponse> result = locationService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponse> GetById(@PathVariable String id) {
        GetLocationRequest request = new GetLocationRequest();
        request.setId(id);
        LocationResponse result = locationService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationResponse> Post(@RequestBody AddLocationRequest request) {
        LocationResponse result = locationService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationResponse> Put(@PathVariable String id, @RequestBody EditLocationRequest request) {
        request.setId(id);
        LocationResponse result = locationService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<LocationResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {
        SearchLocationRequest request = new SearchLocationRequest();
        request.setName(name);
        Iterable<LocationResponse> result = locationService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
