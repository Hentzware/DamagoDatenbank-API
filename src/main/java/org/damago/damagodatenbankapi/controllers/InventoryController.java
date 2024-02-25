package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.inventory.*;
import org.damago.damagodatenbankapi.responses.InventoryResponse;
import org.damago.damagodatenbankapi.services.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/inventories")
@Transactional
@Tag(name = "Inventories")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id,
                                       @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteInventoryRequest request = new DeleteInventoryRequest();
        request.setId(id);
        inventoryService.Delete(request, permanent);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<InventoryResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<InventoryResponse> result = inventoryService.Get(deleted);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponse> GetById(@PathVariable String id) {
        GetInventoryRequest request = new GetInventoryRequest();
        request.setId(id);
        InventoryResponse result = inventoryService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventoryResponse> Post(@RequestBody AddInventoryRequest request) {
        InventoryResponse result = inventoryService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryResponse> Put(@PathVariable String id, @RequestBody EditInventoryRequest request) {
        request.setId(id);
        InventoryResponse result = inventoryService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<InventoryResponse>> Search(
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "amount") int amount) {
        SearchInventoryRequest request = new SearchInventoryRequest();
        request.setName(name);
        request.setAmount(amount);
        Iterable<InventoryResponse> result = inventoryService.Search(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
