package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.modulePerson.*;
import org.damago.damagodatenbankapi.responses.ModulePersonResponse;
import org.damago.damagodatenbankapi.services.ModulePersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/modulePerson")
@Transactional
@Tag(name = "ModulePerson")
public class ModulePersonController {
    private final ModulePersonService modulePersonService;

    public ModulePersonController(ModulePersonService modulePersonService) {
        this.modulePersonService = modulePersonService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteModulePersonRequest request = new DeleteModulePersonRequest();

        request.setId(id);
        modulePersonService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<ModulePersonResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<ModulePersonResponse> result = modulePersonService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModulePersonResponse> GetById(@PathVariable String id) {
        GetModulePersonRequest request = new GetModulePersonRequest();

        request.setId(id);

        ModulePersonResponse result = modulePersonService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ModulePersonResponse> Post(@RequestBody AddModulePersonRequest request) {
        ModulePersonResponse result = modulePersonService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModulePersonResponse> Put(@PathVariable String id, @RequestBody EditModulePersonRequest request) {
        request.setId(id);
        ModulePersonResponse result = modulePersonService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<ModulePersonResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchModulePersonRequest request = new SearchModulePersonRequest();

        // request.setName(name);

        Iterable<ModulePersonResponse> result = modulePersonService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
