package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.address.*;
import org.damago.damagodatenbankapi.responses.AddressResponse;
import org.damago.damagodatenbankapi.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/address")
@Transactional
@Tag(name = "Address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteAddressRequest request = new DeleteAddressRequest();

        request.setId(id);
        addressService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<AddressResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<AddressResponse> result = addressService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> GetById(@PathVariable String id) {
        GetAddressRequest request = new GetAddressRequest();

        request.setId(id);

        AddressResponse result = addressService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressResponse> Post(@RequestBody AddAddressRequest request) {
        AddressResponse result = addressService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> Put(@PathVariable String id, @RequestBody EditAddressRequest request) {
        request.setId(id);
        AddressResponse result = addressService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<AddressResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchAddressRequest request = new SearchAddressRequest();

        // request.setName(name);

        Iterable<AddressResponse> result = addressService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
