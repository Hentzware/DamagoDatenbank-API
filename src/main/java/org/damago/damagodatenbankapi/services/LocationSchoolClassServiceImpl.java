package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.LocationSchoolClass;
import org.damago.damagodatenbankapi.repositories.LocationSchoolClassRepository;
import org.damago.damagodatenbankapi.requests.locationSchoolClass.*;
import org.damago.damagodatenbankapi.responses.LocationSchoolClassResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class LocationSchoolClassServiceImpl implements LocationSchoolClassService {
    private final LocationSchoolClassRepository locationSchoolClassRepository;
    private final ModelMapper modelMapper;

    public LocationSchoolClassServiceImpl(LocationSchoolClassRepository locationSchoolClassRepository, ModelMapper modelMapper) {
        this.locationSchoolClassRepository = locationSchoolClassRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LocationSchoolClassResponse Add(AddLocationSchoolClassRequest request) {
        String id = locationSchoolClassRepository.sp_LocationSchoolClass_Add();
        LocationSchoolClass locationSchoolClass = locationSchoolClassRepository.sp_LocationSchoolClass_GetById(id);
        return modelMapper.map(locationSchoolClass, LocationSchoolClassResponse.class);
    }

    @Override
    public void Delete(DeleteLocationSchoolClassRequest request, boolean permanent) {
        if (permanent) {
            locationSchoolClassRepository.sp_LocationSchoolClass_DeletePermanent(request.getId());
            return;
        }
        locationSchoolClassRepository.sp_LocationSchoolClass_Delete(request.getId());
    }

    @Override
    public LocationSchoolClassResponse Edit(EditLocationSchoolClassRequest request) {
        locationSchoolClassRepository.sp_LocationSchoolClass_Update(request.getId());
        LocationSchoolClass locationSchoolClass = locationSchoolClassRepository.sp_LocationSchoolClass_GetById(request.getId());
        return modelMapper.map(locationSchoolClass, LocationSchoolClassResponse.class);
    }

    @Override
    public Iterable<LocationSchoolClassResponse> Get(boolean deleted) {
        Iterable<LocationSchoolClass> LocationSchoolClasss;

        if (deleted) {
            LocationSchoolClasss = locationSchoolClassRepository.sp_LocationSchoolClass_GetDeleted();
        } else {
            LocationSchoolClasss = locationSchoolClassRepository.sp_LocationSchoolClass_Get();
        }

        return modelMapper.map(LocationSchoolClasss, new TypeToken<Iterable<LocationSchoolClassResponse>>() {
        }.getType());
    }

    @Override
    public LocationSchoolClassResponse GetById(GetLocationSchoolClassRequest request) {
        LocationSchoolClass locationSchoolClass = locationSchoolClassRepository.sp_LocationSchoolClass_GetById(request.getId());
        return modelMapper.map(locationSchoolClass, LocationSchoolClassResponse.class);
    }

    @Override
    public Iterable<LocationSchoolClassResponse> Search(SearchLocationSchoolClassRequest request) {
        Iterable<LocationSchoolClass> LocationSchoolClasss = locationSchoolClassRepository.sp_LocationSchoolClass_Search();
        return modelMapper.map(LocationSchoolClasss, new TypeToken<Iterable<LocationSchoolClassResponse>>() {
        }.getType());
    }
}
