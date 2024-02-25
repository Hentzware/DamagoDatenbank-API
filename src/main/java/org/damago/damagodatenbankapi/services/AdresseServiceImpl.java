package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Address;
import org.damago.damagodatenbankapi.repositories.AddressRepository;
import org.damago.damagodatenbankapi.requests.address.*;
import org.damago.damagodatenbankapi.responses.AddressResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class AdresseServiceImpl implements AddressService {
    private final AddressRepository adresseRepository;
    private final ModelMapper modelMapper;

    public AdresseServiceImpl(AddressRepository adresseRepository, ModelMapper modelMapper) {
        this.adresseRepository = adresseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddressResponse Add(AddAddressRequest request) {
        String id = adresseRepository.sp_Addresses_Add(request.getStreet(), request.getHouse_number(), request.getPostal_code(), request.getLocation(), request.getCountry());
        Address address = adresseRepository.sp_Addresses_GetById(id);
        return modelMapper.map(address, AddressResponse.class);
    }

    @Override
    public void Delete(DeleteAddressRequest request, boolean permanent) {
        if (permanent) {
            adresseRepository.sp_Addresses_DeletePermanent(request.getId());
            return;
        }
        adresseRepository.sp_Addresses_Delete(request.getId());
    }

    @Override
    public AddressResponse Edit(EditAddressRequest request) {
        adresseRepository.sp_Addresses_Update(request.getId(), request.getStreet(), request.getHouse_number(), request.getPostal_code(), request.getLocation(), request.getCountry());
        Address address = adresseRepository.sp_Addresses_GetById(request.getId());
        return modelMapper.map(address, AddressResponse.class);
    }

    @Override
    public Iterable<AddressResponse> Get(boolean deleted) {
        Iterable<Address> addresses;

        if (deleted) {
            addresses = adresseRepository.sp_Addresses_GetDeleted();
        } else {
            addresses = adresseRepository.sp_Addresses_Get();
        }

        return modelMapper.map(addresses, new TypeToken<Iterable<AddressResponse>>() {
        }.getType());
    }

    @Override
    public AddressResponse GetById(GetAddressRequest request) {
        Address address = adresseRepository.sp_Addresses_GetById(request.getId());
        return modelMapper.map(address, AddressResponse.class);
    }

    @Override
    public Iterable<AddressResponse> Search(SearchAdresseRequest request) {
        Iterable<Address> addresses = adresseRepository.sp_Addresses_Search(request.getStreet(), request.getHouse_number(), request.getPostal_code(), request.getLocation(), request.getCountry());
        return modelMapper.map(addresses, new TypeToken<Iterable<AddressResponse>>() {
        }.getType());
    }
}
