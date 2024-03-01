package org.damago.damagodatenbankapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.damago.damagodatenbankapi.requests.room.*;
import org.damago.damagodatenbankapi.responses.RoomResponse;
import org.damago.damagodatenbankapi.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damago/api/v1/room")
@Transactional
@Tag(name = "Room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable String id, @RequestParam(required = false, value = "permanent", defaultValue = "false") boolean permanent) {
        DeleteRoomRequest request = new DeleteRoomRequest();

        request.setId(id);
        roomService.Delete(request, permanent);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<RoomResponse>> Get(@RequestParam(required = false, value = "deleted", defaultValue = "false") boolean deleted) {
        Iterable<RoomResponse> result = roomService.Get(deleted);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> GetById(@PathVariable String id) {
        GetRoomRequest request = new GetRoomRequest();

        request.setId(id);

        RoomResponse result = roomService.GetById(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoomResponse> Post(@RequestBody AddRoomRequest request) {
        RoomResponse result = roomService.Add(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> Put(@PathVariable String id, @RequestBody EditRoomRequest request) {
        request.setId(id);
        RoomResponse result = roomService.Edit(request);

        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<RoomResponse>> Search(
            @RequestParam(required = false, value = "name") String name) {

        SearchRoomRequest request = new SearchRoomRequest();

        // request.setName(name);

        Iterable<RoomResponse> result = roomService.Search(request);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
