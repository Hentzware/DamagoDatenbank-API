package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Room;
import org.damago.damagodatenbankapi.repositories.RoomRepository;
import org.damago.damagodatenbankapi.requests.room.*;
import org.damago.damagodatenbankapi.responses.RoomResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

    public RoomServiceImpl(RoomRepository roomRepository, ModelMapper modelMapper) {
        this.roomRepository = roomRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoomResponse Add(AddRoomRequest request) {
        String id = roomRepository.sp_Rooms_Add();
        Room room = roomRepository.sp_Rooms_GetById(id);
        return modelMapper.map(room, RoomResponse.class);
    }

    @Override
    public void Delete(DeleteRoomRequest request, boolean permanent) {
        if (permanent) {
            roomRepository.sp_Rooms_DeletePermanent(request.getId());
            return;
        }
        roomRepository.sp_Rooms_Delete(request.getId());
    }

    @Override
    public RoomResponse Edit(EditRoomRequest request) {
        roomRepository.sp_Rooms_Update(request.getId());
        Room room = roomRepository.sp_Rooms_GetById(request.getId());
        return modelMapper.map(room, RoomResponse.class);
    }

    @Override
    public Iterable<RoomResponse> Get(boolean deleted) {
        Iterable<Room> rooms;

        if (deleted) {
            rooms = roomRepository.sp_Rooms_GetDeleted();
        } else {
            rooms = roomRepository.sp_Rooms_Get();
        }

        return modelMapper.map(rooms, new TypeToken<Iterable<RoomResponse>>() {
        }.getType());
    }

    @Override
    public RoomResponse GetById(GetRoomRequest request) {
        Room room = roomRepository.sp_Rooms_GetById(request.getId());
        return modelMapper.map(room, RoomResponse.class);
    }

    @Override
    public Iterable<RoomResponse> Search(SearchRoomRequest request) {
        Iterable<Room> rooms = roomRepository.sp_Rooms_Search();
        return modelMapper.map(rooms, new TypeToken<Iterable<RoomResponse>>() {
        }.getType());
    }
}
