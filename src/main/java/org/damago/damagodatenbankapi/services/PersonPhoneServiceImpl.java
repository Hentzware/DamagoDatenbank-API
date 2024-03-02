package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.PersonPhone;
import org.damago.damagodatenbankapi.repositories.PersonPhoneRepository;
import org.damago.damagodatenbankapi.requests.personPhone.*;
import org.damago.damagodatenbankapi.responses.PersonPhoneResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PersonPhoneServiceImpl implements PersonPhoneService {
    private final PersonPhoneRepository personPhoneRepository;
    private final ModelMapper modelMapper;

    public PersonPhoneServiceImpl(PersonPhoneRepository personPhoneRepository, ModelMapper modelMapper) {
        this.personPhoneRepository = personPhoneRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonPhoneResponse Add(AddPersonPhoneRequest request) {
        String id = personPhoneRepository.sp_PersonPhone_Add(request.getPerson_id(), request.getPhone_id());
        PersonPhone personPhone = personPhoneRepository.sp_PersonPhone_GetById(id);
        return modelMapper.map(personPhone, PersonPhoneResponse.class);
    }

    @Override
    public void Delete(DeletePersonPhoneRequest request, boolean permanent) {
        if (permanent) {
            personPhoneRepository.sp_PersonPhone_DeletePermanent(request.getId());
            return;
        }
        personPhoneRepository.sp_PersonPhone_Delete(request.getId());
    }

    @Override
    public PersonPhoneResponse Edit(EditPersonPhoneRequest request) {
        personPhoneRepository.sp_PersonPhone_Update(request.getId(), request.getPerson_id(), request.getPhone_id());
        PersonPhone personPhone = personPhoneRepository.sp_PersonPhone_GetById(request.getId());
        return modelMapper.map(personPhone, PersonPhoneResponse.class);
    }

    @Override
    public Iterable<PersonPhoneResponse> Get(boolean deleted) {
        Iterable<PersonPhone> personsPhones;

        if (deleted) {
            personsPhones = personPhoneRepository.sp_PersonPhone_GetDeleted();
        } else {
            personsPhones = personPhoneRepository.sp_PersonPhone_Get();
        }

        return modelMapper.map(personsPhones, new TypeToken<Iterable<PersonPhoneResponse>>() {
        }.getType());
    }

    @Override
    public PersonPhoneResponse GetById(GetPersonPhoneRequest request) {
        PersonPhone personPhone = personPhoneRepository.sp_PersonPhone_GetById(request.getId());
        return modelMapper.map(personPhone, PersonPhoneResponse.class);
    }

    @Override
    public Iterable<PersonPhoneResponse> Search(SearchPersonPhoneRequest request) {
        Iterable<PersonPhone> personsPhones = personPhoneRepository.sp_PersonPhone_Search(request.getPerson_id(), request.getPhone_id());
        return modelMapper.map(personsPhones, new TypeToken<Iterable<PersonPhoneResponse>>() {
        }.getType());
    }
}
