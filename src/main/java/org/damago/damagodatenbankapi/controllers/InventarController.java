package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.inventar.*;
import org.damago.damagodatenbankapi.responses.InventarResponse;
import org.damago.damagodatenbankapi.services.InventarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/inventar")
@Transactional
@Tag(name = "Inventar")
public class InventarController {
    private final InventarService inventarService;

    public InventarController(InventarService inventarService) {
        this.inventarService = inventarService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteInventarRequest request = new DeleteInventarRequest();
        request.setId(id);
        inventarService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<InventarResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<InventarResponse> result = inventarService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarResponse> GetById(@PathVariable String id) {
        GetInventarRequest request = new GetInventarRequest();
        request.setId(id);
        InventarResponse result = inventarService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventarResponse> Post(@RequestBody AddInventarRequest request) {
        InventarResponse result = inventarService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarResponse> Put(@PathVariable String id, @RequestBody EditInventarRequest request) {
        request.setId(id);
        InventarResponse result = inventarService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<InventarResponse>> Search(
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "anzahl") int anzahl) {
        SearchInventarRequest request = new SearchInventarRequest();
        request.setName(name);
        request.setAnzahl(anzahl);
        Iterable<InventarResponse> result = inventarService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
