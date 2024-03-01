package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Address;
import org.damago.damagodatenbankapi.repositories.AddressRepository;
import org.damago.damagodatenbankapi.requests.address.*;
import org.damago.damagodatenbankapi.responses.AddressResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddressResponse Add(AddAddressRequest request) {
        String id = addressRepository.sp_Addresses_Add();
        Address address = addressRepository.sp_Addresses_GetById(id);
        return modelMapper.map(address, AddressResponse.class);
    }

    @Override
    public void Delete(DeleteAddressRequest request, boolean permanent) {
        if (permanent) {
            addressRepository.sp_Addresses_DeletePermanent(request.getId());
            return;
        }
        addressRepository.sp_Addresses_Delete(request.getId());
    }

    @Override
    public AddressResponse Edit(EditAddressRequest request) {
        addressRepository.sp_Addresses_Update(request.getId());
        Address address = addressRepository.sp_Addresses_GetById(request.getId());
        return modelMapper.map(address, AddressResponse.class);
    }

    @Override
    public Iterable<AddressResponse> Get(boolean deleted) {
        Iterable<Address> addresses;

        if (deleted) {
            addresses = addressRepository.sp_Addresses_GetDeleted();
        } else {
            addresses = addressRepository.sp_Addresses_Get();
        }

        return modelMapper.map(addresses, new TypeToken<Iterable<AddressResponse>>() {
        }.getType());
    }

    @Override
    public AddressResponse GetById(GetAddressRequest request) {
        Address address = addressRepository.sp_Addresses_GetById(request.getId());
        return modelMapper.map(address, AddressResponse.class);
    }

    @Override
    public Iterable<AddressResponse> Search(SearchAddressRequest request) {
        Iterable<Address> addresses = addressRepository.sp_Addresses_Search();
        return modelMapper.map(addresses, new TypeToken<Iterable<AddressResponse>>() {
        }.getType());
    }
}
