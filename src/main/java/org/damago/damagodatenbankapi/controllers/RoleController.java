package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.role.*;
import org.damago.damagodatenbankapi.responses.RoleResponse;
import org.damago.damagodatenbankapi.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/role")
@Transactional
@Tag(name = "Role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteRoleRequest request = new DeleteRoleRequest();

        request.setId(id);
        roleService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<RoleResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<RoleResponse> result = roleService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> GetById(@PathVariable String id) {
        GetRoleRequest request = new GetRoleRequest();

        request.setId(id);

        RoleResponse result = roleService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleResponse> Post(@RequestBody AddRoleRequest request) {
        RoleResponse result = roleService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponse> Put(@PathVariable String id, @RequestBody EditRoleRequest request) {
        request.setId(id);
        RoleResponse result = roleService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<RoleResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchRoleRequest request = new SearchRoleRequest();

        // request.setName(name);

        Iterable<RoleResponse> result = roleService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
