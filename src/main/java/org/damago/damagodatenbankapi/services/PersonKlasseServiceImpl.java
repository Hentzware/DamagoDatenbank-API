package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.PersonKlasse;
import org.damago.damagodatenbankapi.repositories.PersonKlasseRepository;
import org.damago.damagodatenbankapi.requests.personKlasse.*;
import org.damago.damagodatenbankapi.responses.PersonKlasseResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PersonKlasseServiceImpl implements PersonKlasseService {
    private final PersonKlasseRepository personKlasseRepository;
    private final ModelMapper modelMapper;

    public PersonKlasseServiceImpl(PersonKlasseRepository personKlasseRepository, ModelMapper modelMapper) {
        this.personKlasseRepository = personKlasseRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public PersonKlasseResponse Add(AddPersonKlasseRequest request) {
        String id = personKlasseRepository.sp_PersonClass_Add(request.getPersonId(), request.getKlasseId());
        PersonKlasse personKlasse = personKlasseRepository.sp_PersonClass_GetById(id);
        return modelMapper.map(personKlasse, PersonKlasseResponse.class);
    }

    @Override
    public void Delete(DeletePersonKlasseRequest request, boolean permanent) {
        if (permanent) {
            personKlasseRepository.sp_PersonClass_DeletePermanent(request.getId());
            return;
        }
        personKlasseRepository.sp_PersonClass_Delete(request.getId());
    }

    @Override
    public PersonKlasseResponse Edit(EditPersonKlasseRequest request) {
        personKlasseRepository.sp_PersonClass_Update(request.getId(), request.getPersonId(), request.getKlasseId());
        PersonKlasse personKlasse = personKlasseRepository.sp_PersonClass_GetById(request.getId());
        return modelMapper.map(personKlasse, PersonKlasseResponse.class);
    }

    @Override
    public Iterable<PersonKlasseResponse> Get(boolean deleted) {
        Iterable<PersonKlasse> personKlassen;

        if (deleted) {
            personKlassen = personKlasseRepository.sp_PersonClass_GetDeleted();
        } else {
            personKlassen = personKlasseRepository.sp_PersonClass_Get();
        }

        return modelMapper.map(personKlassen, new TypeToken<Iterable<PersonKlasseResponse>>() {
        }.getType());
    }

    @Override
    public PersonKlasseResponse GetById(GetPersonKlasseRequest request) {
        PersonKlasse personKlasse = personKlasseRepository.sp_PersonClass_GetById(request.getId());
        return modelMapper.map(personKlasse, PersonKlasseResponse.class);
    }

    @Override
    public Iterable<PersonKlasseResponse> Search(SearchPersonKlasseRequest request) {
        Iterable<PersonKlasse> personKlassen = personKlasseRepository.sp_PersonClass_Search(request.getPersonId(), request.getKlasseId());
        return modelMapper.map(personKlassen, new TypeToken<Iterable<PersonKlasseResponse>>() {
        }.getType());
    }
}
