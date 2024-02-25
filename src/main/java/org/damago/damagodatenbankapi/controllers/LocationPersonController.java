package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.locationPerson.*;
import org.damago.damagodatenbankapi.responses.LocationPersonResponse;
import org.damago.damagodatenbankapi.services.LocationPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/location-person")
@Transactional
@Tag(name = "Location - Person")
public class LocationPersonController {
    private final LocationPersonService locationPersonService;

    public LocationPersonController(LocationPersonService locationPersonService) {
        this.locationPersonService = locationPersonService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteLocationPersonRequest request = new DeleteLocationPersonRequest();
        request.setId(id);
        locationPersonService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<LocationPersonResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<LocationPersonResponse> result = locationPersonService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationPersonResponse> GetById(@PathVariable String id) {
        GetLocationPersonRequest request = new GetLocationPersonRequest();
        request.setId(id);
        LocationPersonResponse result = locationPersonService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationPersonResponse> Post(@RequestBody AddLocationPersonRequest request) {
        LocationPersonResponse result = locationPersonService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationPersonResponse> Put(@PathVariable String id, @RequestBody EditLocationPersonRequest request) {
        request.setId(id);
        LocationPersonResponse result = locationPersonService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<LocationPersonResponse>> Search(
            @RequestParam(required = false, value = "location_id") String location_id,
            @RequestParam(required = false, value = "person_id") String person_id) {
        SearchLocationPersonRequest request = new SearchLocationPersonRequest();
        request.setLocation_id(location_id);
        request.setPerson_id(person_id);
        Iterable<LocationPersonResponse> result = locationPersonService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
