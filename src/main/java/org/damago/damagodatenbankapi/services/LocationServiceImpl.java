package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Location;
import org.damago.damagodatenbankapi.repositories.LocationRepository;
import org.damago.damagodatenbankapi.requests.location.*;
import org.damago.damagodatenbankapi.responses.LocationResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository standortRepository;
    private final ModelMapper modelMapper;

    public LocationServiceImpl(LocationRepository standortRepository, ModelMapper modelMapper) {
        this.standortRepository = standortRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LocationResponse Add(AddLocationRequest request) {
        String id = standortRepository.sp_Location_Add(request.getName());
        Location location = standortRepository.sp_Location_GetById(id);
        return modelMapper.map(location, LocationResponse.class);
    }

    @Override
    public void Delete(DeleteLocationRequest request, boolean permanent) {
        if (permanent) {
            standortRepository.sp_Location_DeletePermanent(request.getId());
            return;
        }
        standortRepository.sp_Location_Delete(request.getId());
    }

    @Override
    public LocationResponse Edit(EditLocationRequest request) {
        standortRepository.sp_Location_Update(request.getId(), request.getName());
        Location location = standortRepository.sp_Location_GetById(request.getId());
        return modelMapper.map(location, LocationResponse.class);
    }

    @Override
    public Iterable<LocationResponse> Get(boolean deleted) {
        Iterable<Location> locations;

        if (deleted) {
            locations = standortRepository.sp_Location_GetDeleted();
        } else {
            locations = standortRepository.sp_Location_Get();
        }

        return modelMapper.map(locations, new TypeToken<Iterable<LocationResponse>>() {
        }.getType());
    }

    @Override
    public LocationResponse GetById(GetLocationRequest request) {
        Location location = standortRepository.sp_Location_GetById(request.getId());
        return modelMapper.map(location, LocationResponse.class);
    }

    @Override
    public Iterable<LocationResponse> Search(SearchLocationRequest request) {
        Iterable<Location> standorte = standortRepository.sp_Location_Search(request.getName());
        return modelMapper.map(standorte, new TypeToken<Iterable<LocationResponse>>() {
        }.getType());
    }
}
