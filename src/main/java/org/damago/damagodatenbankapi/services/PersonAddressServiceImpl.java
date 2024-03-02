package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.PersonAddress;
import org.damago.damagodatenbankapi.repositories.PersonAddressRepository;
import org.damago.damagodatenbankapi.requests.personAddress.*;
import org.damago.damagodatenbankapi.responses.PersonAddressResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PersonAddressServiceImpl implements PersonAddressService {
    private final PersonAddressRepository personAddressRepository;
    private final ModelMapper modelMapper;

    public PersonAddressServiceImpl(PersonAddressRepository personAddressRepository, ModelMapper modelMapper) {
        this.personAddressRepository = personAddressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonAddressResponse Add(AddPersonAddressRequest request) {
        String id = personAddressRepository.sp_PersonAddress_Add(request.getPerson_id(), request.getAddress_id());
        PersonAddress personAddress = personAddressRepository.sp_PersonAddress_GetById(id);
        return modelMapper.map(personAddress, PersonAddressResponse.class);
    }

    @Override
    public void Delete(DeletePersonAddressRequest request, boolean permanent) {
        if (permanent) {
            personAddressRepository.sp_PersonAddress_DeletePermanent(request.getId());
            return;
        }
        personAddressRepository.sp_PersonAddress_Delete(request.getId());
    }

    @Override
    public PersonAddressResponse Edit(EditPersonAddressRequest request) {
        personAddressRepository.sp_PersonAddress_Update(request.getId(), request.getPerson_id(), request.getAddress_id());
        PersonAddress personAddress = personAddressRepository.sp_PersonAddress_GetById(request.getId());
        return modelMapper.map(personAddress, PersonAddressResponse.class);
    }

    @Override
    public Iterable<PersonAddressResponse> Get(boolean deleted) {
        Iterable<PersonAddress> personsAddresses;

        if (deleted) {
            personsAddresses = personAddressRepository.sp_PersonAddress_GetDeleted();
        } else {
            personsAddresses = personAddressRepository.sp_PersonAddress_Get();
        }

        return modelMapper.map(personsAddresses, new TypeToken<Iterable<PersonAddressResponse>>() {
        }.getType());
    }

    @Override
    public PersonAddressResponse GetById(GetPersonAddressRequest request) {
        PersonAddress personAddress = personAddressRepository.sp_PersonAddress_GetById(request.getId());
        return modelMapper.map(personAddress, PersonAddressResponse.class);
    }

    @Override
    public Iterable<PersonAddressResponse> Search(SearchPersonAddressRequest request) {
        Iterable<PersonAddress> personsAddresses = personAddressRepository.sp_PersonAddress_Search(request.getPerson_id(), request.getAddress_id());
        return modelMapper.map(personsAddresses, new TypeToken<Iterable<PersonAddressResponse>>() {
        }.getType());
    }
}
