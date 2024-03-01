package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.module.*;
import org.damago.damagodatenbankapi.responses.ModuleResponse;
import org.damago.damagodatenbankapi.services.ModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/module")
@Transactional
@Tag(name = "Module")
public class ModuleController {
    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteModuleRequest request = new DeleteModuleRequest();

        request.setId(id);
        moduleService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<ModuleResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<ModuleResponse> result = moduleService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleResponse> GetById(@PathVariable String id) {
        GetModuleRequest request = new GetModuleRequest();

        request.setId(id);

        ModuleResponse result = moduleService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ModuleResponse> Post(@RequestBody AddModuleRequest request) {
        ModuleResponse result = moduleService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleResponse> Put(@PathVariable String id, @RequestBody EditModuleRequest request) {
        request.setId(id);
        ModuleResponse result = moduleService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<ModuleResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchModuleRequest request = new SearchModuleRequest();

        // request.setName(name);

        Iterable<ModuleResponse> result = moduleService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
