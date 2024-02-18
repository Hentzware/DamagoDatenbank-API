package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Email;
import org.damago.damagodatenbankapi.entities.Standort;
import org.damago.damagodatenbankapi.repositories.StandortRepository;
import org.damago.damagodatenbankapi.requests.standort.*;
import org.damago.damagodatenbankapi.responses.EmailResponse;
import org.damago.damagodatenbankapi.responses.StandortResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public class StandortServiceImpl implements StandortService {
    private final StandortRepository standortRepository;
    private final ModelMapper modelMapper;

    public StandortServiceImpl(StandortRepository standortRepository, ModelMapper modelMapper) {
        this.standortRepository = standortRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StandortResponse Add(AddStandortRequest request) {
        String id = standortRepository.sp_Locations_Add(request.getName());
        Standort standort = standortRepository.sp_Locations_GetById(id);
        return modelMapper.map(standort, StandortResponse.class);
    }

    @Override
    public void Delete(DeleteStandortRequest request, boolean permanent) {
        if (permanent) {
            standortRepository.sp_Locations_DeletePermanent(request.getId());
            return;
        }
        standortRepository.sp_Locations_Delete(request.getId());
    }

    @Override
    public StandortResponse Edit(EditStandortRequest request) {
        standortRepository.sp_Locations_Update(request.getId(), request.getName());
        Standort standort = standortRepository.sp_Locations_GetById(request.getId());
        return modelMapper.map(standort, StandortResponse.class);
    }

    @Override
    public Iterable<StandortResponse> Get(boolean deleted) {
        Iterable<Standort> standorte;

        if (deleted) {
            standorte = standortRepository.sp_Locations_GetDeleted();
        } else {
            standorte = standortRepository.sp_Locations_Get();
        }

        return modelMapper.map(standorte, new TypeToken<Iterable<StandortResponse>>() {
        }.getType());
    }

    @Override
    public StandortResponse GetById(GetStandortRequest request) {
        Standort standort = standortRepository.sp_Locations_GetById(request.getId());
        return modelMapper.map(standort, StandortResponse.class);
    }

    @Override
    public Iterable<StandortResponse> Search(SearchStandortRequest request) {
        Iterable<Standort> standorte = standortRepository.sp_Locations_Search(request.getName());
        return modelMapper.map(standorte, new TypeToken<Iterable<StandortResponse>>() {
        }.getType());
    }
}
