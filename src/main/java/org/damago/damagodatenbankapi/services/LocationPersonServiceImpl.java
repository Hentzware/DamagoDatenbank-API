package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.LocationPerson;
import org.damago.damagodatenbankapi.repositories.LocationPersonRepository;
import org.damago.damagodatenbankapi.requests.locationPerson.*;
import org.damago.damagodatenbankapi.responses.LocationPersonResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class LocationPersonServiceImpl implements LocationPersonService {
    private final LocationPersonRepository locationPersonRepository;
    private final ModelMapper modelMapper;

    public LocationPersonServiceImpl(LocationPersonRepository locationPersonRepository, ModelMapper modelMapper) {
        this.locationPersonRepository = locationPersonRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LocationPersonResponse Add(AddLocationPersonRequest request) {
        String id = locationPersonRepository.sp_LocationPerson_Add(request.getLocation_id(), request.getPerson_id());
        LocationPerson personStandort = locationPersonRepository.sp_LocationPerson_GetById(id);
        return modelMapper.map(personStandort, LocationPersonResponse.class);
    }

    @Override
    public void Delete(DeleteLocationPersonRequest request, boolean permanent) {
        if (permanent) {
            locationPersonRepository.sp_LocationPerson_DeletePermanent(request.getId());
            return;
        }
        locationPersonRepository.sp_LocationPerson_Delete(request.getId());
    }

    @Override
    public LocationPersonResponse Edit(EditLocationPersonRequest request) {
        locationPersonRepository.sp_LocationPerson_Update(request.getId(), request.getLocation_id(), request.getPerson_id());
        LocationPerson personStandort = locationPersonRepository.sp_LocationPerson_GetById(request.getId());
        return modelMapper.map(personStandort, LocationPersonResponse.class);
    }

    @Override
    public Iterable<LocationPersonResponse> Get(boolean deleted) {
        Iterable<LocationPerson> personStandorte;

        if (deleted) {
            personStandorte = locationPersonRepository.sp_LocationPerson_GetDeleted();
        } else {
            personStandorte = locationPersonRepository.sp_LocationPerson_Get();
        }

        return modelMapper.map(personStandorte, new TypeToken<Iterable<LocationPersonResponse>>() {
        }.getType());
    }

    @Override
    public LocationPersonResponse GetById(GetLocationPersonRequest request) {
        LocationPerson personStandort = locationPersonRepository.sp_LocationPerson_GetById(request.getId());
        return modelMapper.map(personStandort, LocationPersonResponse.class);
    }

    @Override
    public Iterable<LocationPersonResponse> Search(SearchLocationPersonRequest request) {
        Iterable<LocationPerson> personStandorte = locationPersonRepository.sp_LocationPerson_Search(request.getLocation_id(), request.getPerson_id());
        return modelMapper.map(personStandorte, new TypeToken<Iterable<LocationPersonResponse>>() {
        }.getType());
    }
}
