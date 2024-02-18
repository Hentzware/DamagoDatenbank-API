package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.PersonRolle;
import org.damago.damagodatenbankapi.repositories.PersonRolleRepository;
import org.damago.damagodatenbankapi.requests.personRolle.*;
import org.damago.damagodatenbankapi.responses.PersonRolleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PersonRolleServiceImpl implements PersonRolleService {
    private final PersonRolleRepository personRolleRepository;
    private final ModelMapper modelMapper;

    public PersonRolleServiceImpl(PersonRolleRepository personRolleRepository, ModelMapper modelMapper) {
        this.personRolleRepository = personRolleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonRolleResponse Add(AddPersonRolleRequest request) {
        String id = personRolleRepository.sp_PersonRole_Add(request.getPersonId(), request.getRolleId());
        PersonRolle personRolle = personRolleRepository.sp_PersonRole_GetById(id);
        return modelMapper.map(personRolle, PersonRolleResponse.class);
    }

    @Override
    public void Delete(DeletePersonRolleRequest request, boolean permanent) {
        if (permanent) {
            personRolleRepository.sp_PersonRole_DeletePermanent(request.getId());
            return;
        }
        personRolleRepository.sp_PersonRole_Delete(request.getId());
    }

    @Override
    public PersonRolleResponse Edit(EditPersonRolleRequest request) {
        personRolleRepository.sp_PersonRole_Update(request.getId(), request.getPersonId(), request.getRolleId());
        PersonRolle personRolle = personRolleRepository.sp_PersonRole_GetById(request.getId());
        return modelMapper.map(personRolle, PersonRolleResponse.class);
    }

    @Override
    public Iterable<PersonRolleResponse> Get(boolean deleted) {
        Iterable<PersonRolle> personRollen;

        if (deleted) {
            personRollen = personRolleRepository.sp_PersonRole_GetDeleted();
        } else {
            personRollen = personRolleRepository.sp_PersonRole_Get();
        }

        return modelMapper.map(personRollen, new TypeToken<Iterable<PersonRolleResponse>>() {
        }.getType());
    }

    @Override
    public PersonRolleResponse GetById(GetPersonRolleRequest request) {
        PersonRolle personRolle = personRolleRepository.sp_PersonRole_GetById(request.getId());
        return modelMapper.map(personRolle, PersonRolleResponse.class);
    }

    @Override
    public Iterable<PersonRolleResponse> Search(SearchPersonRolleRequest request) {
        Iterable<PersonRolle> personRollen = personRolleRepository.sp_PersonRole_Search(request.getPersonId(), request.getRolleId());
        return modelMapper.map(personRollen, new TypeToken<Iterable<PersonRolleResponse>>() {
        }.getType());
    }
}
