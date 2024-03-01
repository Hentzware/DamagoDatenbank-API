package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.room.*;
import org.damago.damagodatenbankapi.responses.RoomResponse;

public interface RoomService {
    RoomResponse Add(AddRoomRequest request);

    void Delete(DeleteRoomRequest request, boolean permanent);

    RoomResponse Edit(EditRoomRequest request);

    Iterable<RoomResponse> Get(boolean deleted);

    RoomResponse GetById(GetRoomRequest request);

    Iterable<RoomResponse> Search(SearchRoomRequest request);
}
