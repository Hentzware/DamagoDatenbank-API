package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.PersonTelefonnummer;
import org.damago.damagodatenbankapi.repositories.PersonTelefonnummerRepository;
import org.damago.damagodatenbankapi.requests.personTelefonnummer.*;
import org.damago.damagodatenbankapi.responses.PersonTelefonnummerResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PersonTelefonnummerServiceImpl implements PersonTelefonnummerService {
    private final PersonTelefonnummerRepository personTelefonnummerRepository;
    private final ModelMapper modelMapper;

    public PersonTelefonnummerServiceImpl(PersonTelefonnummerRepository personTelefonnummerRepository, ModelMapper modelMapper) {
        this.personTelefonnummerRepository = personTelefonnummerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonTelefonnummerResponse Add(AddPersonTelefonnummerRequest request) {
        String id = personTelefonnummerRepository.sp_PersonPhone_Add(request.getPerson_id(), request.getTelefonnummer_id());
        PersonTelefonnummer personTelefonnummer = personTelefonnummerRepository.sp_PersonPhone_GetById(id);
        return modelMapper.map(personTelefonnummer, PersonTelefonnummerResponse.class);
    }

    @Override
    public void Delete(DeletePersonTelefonnummerRequest request, boolean permanent) {
        if (permanent) {
            personTelefonnummerRepository.sp_PersonPhone_DeletePermanent(request.getId());
            return;
        }
        personTelefonnummerRepository.sp_PersonPhone_Delete(request.getId());
    }

    @Override
    public PersonTelefonnummerResponse Edit(EditPersonTelefonnummerRequest request) {
        personTelefonnummerRepository.sp_PersonPhone_Update(request.getId(), request.getPerson_id(), request.getTelefonnummer_id());
        PersonTelefonnummer personTelefonnummer = personTelefonnummerRepository.sp_PersonPhone_GetById(request.getId());
        return modelMapper.map(personTelefonnummer, PersonTelefonnummerResponse.class);
    }

    @Override
    public Iterable<PersonTelefonnummerResponse> Get(boolean deleted) {
        Iterable<PersonTelefonnummer> personTelefonnummern;

        if (deleted) {
            personTelefonnummern = personTelefonnummerRepository.sp_PersonPhone_GetDeleted();
        } else {
            personTelefonnummern = personTelefonnummerRepository.sp_PersonPhone_Get();
        }

        return modelMapper.map(personTelefonnummern, new TypeToken<Iterable<PersonTelefonnummerResponse>>() {
        }.getType());
    }

    @Override
    public PersonTelefonnummerResponse GetById(GetPersonTelefonnummerRequest request) {
        PersonTelefonnummer personTelefonnummer = personTelefonnummerRepository.sp_PersonPhone_GetById(request.getId());
        return modelMapper.map(personTelefonnummer, PersonTelefonnummerResponse.class);
    }

    @Override
    public Iterable<PersonTelefonnummerResponse> Search(SearchPersonTelefonnummerRequest request) {
        Iterable<PersonTelefonnummer> personTelefonnummern = personTelefonnummerRepository.sp_PersonPhone_Search(request.getPerson_id(), request.getTelefonnummer_id());
        return modelMapper.map(personTelefonnummern, new TypeToken<Iterable<PersonTelefonnummerResponse>>() {
        }.getType());
    }
}
