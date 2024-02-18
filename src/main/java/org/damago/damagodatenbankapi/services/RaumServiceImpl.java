package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Raum;
import org.damago.damagodatenbankapi.repositories.RaumRepository;
import org.damago.damagodatenbankapi.requests.raum.*;
import org.damago.damagodatenbankapi.responses.RaumResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class RaumServiceImpl implements RaumService {
    private final RaumRepository raumRepository;
    private final ModelMapper modelMapper;

    public RaumServiceImpl(RaumRepository raumRepository, ModelMapper modelMapper) {
        this.raumRepository = raumRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public RaumResponse Add(AddRaumRequest request) {
        String id = raumRepository.sp_Rooms_Add(request.getName(), request.getNr());
        Raum raum = raumRepository.sp_Rooms_GetById(id);
        return modelMapper.map(raum, RaumResponse.class);
    }

    @Override
    public void Delete(DeleteRaumRequest request, boolean permanent) {
        if (permanent) {
            raumRepository.sp_Rooms_DeletePermanent(request.getId());
            return;
        }
        raumRepository.sp_Rooms_Delete(request.getId());
    }

    @Override
    public RaumResponse Edit(EditRaumRequest request) {
        raumRepository.sp_Rooms_Update(request.getId(), request.getName(), request.getNr());
        Raum raum = raumRepository.sp_Rooms_GetById(request.getId());
        return modelMapper.map(raum, RaumResponse.class);
    }

    @Override
    public Iterable<RaumResponse> Get(boolean deleted) {
        Iterable<Raum> raeume;

        if (deleted) {
            raeume = raumRepository.sp_Rooms_GetDeleted();
        } else {
            raeume = raumRepository.sp_Rooms_Get();
        }

        return modelMapper.map(raeume, new TypeToken<Iterable<RaumResponse>>() {
        }.getType());
    }

    @Override
    public RaumResponse GetById(GetRaumRequest request) {
        Raum raum = raumRepository.sp_Rooms_GetById(request.getId());
        return modelMapper.map(raum, RaumResponse.class);
    }

    @Override
    public Iterable<RaumResponse> Search(SearchRaumRequest request) {
        Iterable<Raum> raeume = raumRepository.sp_Rooms_Search(request.getName(), request.getNr());
        return modelMapper.map(raeume, new TypeToken<Iterable<RaumResponse>>() {
        }.getType());
    }
}
