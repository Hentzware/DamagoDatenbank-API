package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.PersonStandort;
import org.damago.damagodatenbankapi.repositories.PersonStandortRepository;
import org.damago.damagodatenbankapi.requests.personStandort.*;
import org.damago.damagodatenbankapi.responses.PersonStandortResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PersonStandortServiceImpl implements PersonStandortService {
    private final PersonStandortRepository personStandortRepository;
    private final ModelMapper modelMapper;

    public PersonStandortServiceImpl(PersonStandortRepository personStandortRepository, ModelMapper modelMapper) {
        this.personStandortRepository = personStandortRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonStandortResponse Add(AddPersonStandortRequest request) {
        String id = personStandortRepository.sp_PersonLocation_Add(request.getPersonId(), request.getStandortId());
        PersonStandort personStandort = personStandortRepository.sp_PersonLocation_GetById(id);
        return modelMapper.map(personStandort, PersonStandortResponse.class);
    }

    @Override
    public void Delete(DeletePersonStandortRequest request, boolean permanent) {
        if (permanent) {
            personStandortRepository.sp_PersonLocation_DeletePermanent(request.getId());
            return;
        }
        personStandortRepository.sp_PersonLocation_Delete(request.getId());
    }

    @Override
    public PersonStandortResponse Edit(EditPersonStandortRequest request) {
        personStandortRepository.sp_PersonLocation_Update(request.getId(), request.getPersonId(), request.getStandortId());
        PersonStandort personStandort = personStandortRepository.sp_PersonLocation_GetById(request.getId());
        return modelMapper.map(personStandort, PersonStandortResponse.class);
    }

    @Override
    public Iterable<PersonStandortResponse> Get(boolean deleted) {
        Iterable<PersonStandort> personStandorte;

        if (deleted) {
            personStandorte = personStandortRepository.sp_PersonLocation_GetDeleted();
        } else {
            personStandorte = personStandortRepository.sp_PersonLocation_Get();
        }

        return modelMapper.map(personStandorte, new TypeToken<Iterable<PersonStandortResponse>>() {
        }.getType());
    }

    @Override
    public PersonStandortResponse GetById(GetPersonStandortRequest request) {
        PersonStandort personStandort = personStandortRepository.sp_PersonLocation_GetById(request.getId());
        return modelMapper.map(personStandort, PersonStandortResponse.class);
    }

    @Override
    public Iterable<PersonStandortResponse> Search(SearchPersonStandortRequest request) {
        Iterable<PersonStandort> personStandorte = personStandortRepository.sp_PersonLocation_Search(request.getPersonId(), request.getStandortId());
        return modelMapper.map(personStandorte, new TypeToken<Iterable<PersonStandortResponse>>() {
        }.getType());
    }
}
