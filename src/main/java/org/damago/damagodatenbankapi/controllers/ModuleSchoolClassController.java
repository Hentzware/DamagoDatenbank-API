package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.moduleSchoolClass.*;
import org.damago.damagodatenbankapi.responses.ModuleSchoolClassResponse;
import org.damago.damagodatenbankapi.services.ModuleSchoolClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/moduleSchoolClass")
@Transactional
@Tag(name = "ModuleSchoolClass")
public class ModuleSchoolClassController {
    private final ModuleSchoolClassService moduleSchoolClassService;

    public ModuleSchoolClassController(ModuleSchoolClassService moduleSchoolClassService) {
        this.moduleSchoolClassService = moduleSchoolClassService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteModuleSchoolClassRequest request = new DeleteModuleSchoolClassRequest();

        request.setId(id);
        moduleSchoolClassService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<ModuleSchoolClassResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<ModuleSchoolClassResponse> result = moduleSchoolClassService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleSchoolClassResponse> GetById(@PathVariable String id) {
        GetModuleSchoolClassRequest request = new GetModuleSchoolClassRequest();

        request.setId(id);

        ModuleSchoolClassResponse result = moduleSchoolClassService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ModuleSchoolClassResponse> Post(@RequestBody AddModuleSchoolClassRequest request) {
        ModuleSchoolClassResponse result = moduleSchoolClassService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleSchoolClassResponse> Put(@PathVariable String id, @RequestBody EditModuleSchoolClassRequest request) {
        request.setId(id);
        ModuleSchoolClassResponse result = moduleSchoolClassService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<ModuleSchoolClassResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchModuleSchoolClassRequest request = new SearchModuleSchoolClassRequest();

        // request.setName(name);

        Iterable<ModuleSchoolClassResponse> result = moduleSchoolClassService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
