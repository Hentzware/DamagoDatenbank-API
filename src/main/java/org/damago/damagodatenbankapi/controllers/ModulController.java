package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.adresse.*;
import org.damago.damagodatenbankapi.requests.modul.*;
import org.damago.damagodatenbankapi.responses.AdresseResponse;
import org.damago.damagodatenbankapi.responses.ModulResponse;
import org.damago.damagodatenbankapi.services.AdresseService;
import org.damago.damagodatenbankapi.services.ModulService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/module")
@Transactional
@Tag(name = "Module")
public class ModulController {
    private final ModulService modulService;

    public ModulController(ModulService modulService) {
        this.modulService = modulService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteModulRequest request = new DeleteModulRequest();

        request.setId(id);
        modulService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<ModulResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<ModulResponse> result = modulService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModulResponse> GetById(@PathVariable String id) {
        GetModulRequest request = new GetModulRequest();

        request.setId(id);

        ModulResponse result = modulService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ModulResponse> Post(@RequestBody AddModulRequest request) {
        ModulResponse result = modulService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModulResponse> Put(
            @PathVariable String id,
            @RequestBody EditModulRequest request) {

        request.setId(id);
        ModulResponse result = modulService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<ModulResponse>> Search(
            @RequestParam(required = false, value = "name") String name)
        /*   @RequestParam(required = false, value = "beschreibung") String dauer)
       @RequestParam(required = false, value = "postleitzahl") String postleitzahl,
      @RequestParam(required = false, value = "ort") String ort,
      @RequestParam(required = false, value = "land") String land)*/ {

        SearchModulRequest request = new SearchModulRequest();

        request.setName(name);

      /* request.setDauer(dauer)
       request.setPostleitzahl(postleitzahl);
        request.setOrt(ort);
        request.setLand(land);

       */

        Iterable<ModulResponse> result = modulService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
