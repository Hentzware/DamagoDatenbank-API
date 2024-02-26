package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.schoolClass.*;
import org.damago.damagodatenbankapi.responses.SchoolClassResponse;
import org.damago.damagodatenbankapi.services.SchoolClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/school-classes")
@Transactional
@Tag(name = "School Classes")
public class SchoolClassController {
    private final SchoolClassService classService;

    public SchoolClassController(SchoolClassService classService) {
        this.classService = classService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteSchoolClassRequest request = new DeleteSchoolClassRequest();
        request.setId(id);
        classService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<SchoolClassResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<SchoolClassResponse> result = classService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolClassResponse> GetById(@PathVariable String id) {
        GetSchoolClassRequest request = new GetSchoolClassRequest();
        request.setId(id);
        SchoolClassResponse result = classService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SchoolClassResponse> Post(@RequestBody AddSchoolClassRequest request) {
        SchoolClassResponse result = classService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolClassResponse> Put(@PathVariable String id, @RequestBody EditSchoolClassRequest request) {
        request.setId(id);
        SchoolClassResponse result = classService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<SchoolClassResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {
        SearchSchoolClassRequest request = new SearchSchoolClassRequest();
        request.setName(name);
        Iterable<SchoolClassResponse> result = classService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
