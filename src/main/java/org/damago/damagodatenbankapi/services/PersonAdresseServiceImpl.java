package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.PersonAdresse;
import org.damago.damagodatenbankapi.repositories.PersonAdresseRepository;
import org.damago.damagodatenbankapi.requests.personAdresse.*;
import org.damago.damagodatenbankapi.responses.PersonAdresseResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public class PersonAdresseServiceImpl implements PersonAdresseService {
    private final PersonAdresseRepository personAdresseRepository;
    private final ModelMapper modelMapper;

    public PersonAdresseServiceImpl(PersonAdresseRepository personAdresseRepository, ModelMapper modelMapper) {
        this.personAdresseRepository = personAdresseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonAdresseResponse Add(AddPersonAdresseRequest request) {
        String id = personAdresseRepository.sp_PersonAdress_Add(request.getPersonId(), request.getAdresseId());
        PersonAdresse personAdresse = personAdresseRepository.sp_PersonAdress_GetById(id);
        return modelMapper.map(personAdresse, PersonAdresseResponse.class);
    }

    @Override
    public void Delete(DeletePersonAdresseRequest request, boolean permanent) {
        if (permanent) {
            personAdresseRepository.sp_PersonAdress_DeletePermanent(request.getId());
            return;
        }
        personAdresseRepository.sp_PersonAdress_Delete(request.getId());
    }

    @Override
    public PersonAdresseResponse Edit(EditPersonAdresseRequest request) {
        personAdresseRepository.sp_PersonAdress_Update(request.getId(), request.getPersonId(), request.getAdresseId());
        PersonAdresse personAdresse = personAdresseRepository.sp_PersonAdress_GetById(request.getId());
        return modelMapper.map(personAdresse, PersonAdresseResponse.class);
    }

    @Override
    public Iterable<PersonAdresseResponse> Get(boolean deleted) {
        Iterable<PersonAdresse> personAdressen;

        if (deleted) {
            personAdressen = personAdresseRepository.sp_PersonAdress_GetDeleted();
        } else {
            personAdressen = personAdresseRepository.sp_PersonAdress_Get();
        }

        return modelMapper.map(personAdressen, new TypeToken<Iterable<PersonAdresseResponse>>() {
        }.getType());
    }

    @Override
    public PersonAdresseResponse GetById(GetPersonAdresseRequest request) {
        PersonAdresse personAdresse = personAdresseRepository.sp_PersonAdress_GetById(request.getId());
        return modelMapper.map(personAdresse, PersonAdresseResponse.class);
    }

    @Override
    public Iterable<PersonAdresseResponse> Search(SearchPersonAdresseRequest request) {
        Iterable<PersonAdresse> personAdressen = personAdresseRepository.sp_PersonAdress_Search(request.getPersonId(), request.getAdresseId());
        return modelMapper.map(personAdressen, new TypeToken<Iterable<PersonAdresse>>() {
        }.getType());
    }
}
