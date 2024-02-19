package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.rolle.*;
import org.damago.damagodatenbankapi.responses.RolleResponse;
import org.damago.damagodatenbankapi.services.RolleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/rollen")
@Transactional
@Tag(name = "Rollen")
public class RolleController {
    private final RolleService rolleService;

    public RolleController(RolleService rolleService) {
        this.rolleService = rolleService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteRolleRequest request = new DeleteRolleRequest();
        request.setId(id);
        rolleService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<RolleResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<RolleResponse> result = rolleService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolleResponse> GetById(@PathVariable String id) {
        GetRolleRequest request = new GetRolleRequest();
        request.setId(id);
        RolleResponse result = rolleService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RolleResponse> Post(@RequestBody AddRolleRequest request) {
        RolleResponse result = rolleService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolleResponse> Put(@PathVariable String id, @RequestBody EditRolleRequest request) {
        request.setId(id);
        RolleResponse result = rolleService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<RolleResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {
        SearchRolleRequest request = new SearchRolleRequest();
        request.setName(name);
        Iterable<RolleResponse> result = rolleService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
