package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.PersonSchoolClass;
import org.damago.damagodatenbankapi.repositories.PersonSchoolClassRepository;
import org.damago.damagodatenbankapi.requests.personSchoolClass.*;
import org.damago.damagodatenbankapi.responses.PersonSchoolClassResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PersonSchoolClassServiceImpl implements PersonSchoolClassService {
    private final PersonSchoolClassRepository personSchoolClassRepository;
    private final ModelMapper modelMapper;

    public PersonSchoolClassServiceImpl(PersonSchoolClassRepository personSchoolClassRepository, ModelMapper modelMapper) {
        this.personSchoolClassRepository = personSchoolClassRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonSchoolClassResponse Add(AddPersonSchoolClassRequest request) {
        String id = personSchoolClassRepository.sp_PersonsSchoolClasses_Add();
        PersonSchoolClass personSchoolClass = personSchoolClassRepository.sp_PersonsSchoolClasses_GetById(id);
        return modelMapper.map(personSchoolClass, PersonSchoolClassResponse.class);
    }

    @Override
    public void Delete(DeletePersonSchoolClassRequest request, boolean permanent) {
        if (permanent) {
            personSchoolClassRepository.sp_PersonsSchoolClasses_DeletePermanent(request.getId());
            return;
        }
        personSchoolClassRepository.sp_PersonsSchoolClasses_Delete(request.getId());
    }

    @Override
    public PersonSchoolClassResponse Edit(EditPersonSchoolClassRequest request) {
        personSchoolClassRepository.sp_PersonsSchoolClasses_Update(request.getId());
        PersonSchoolClass personSchoolClass = personSchoolClassRepository.sp_PersonsSchoolClasses_GetById(request.getId());
        return modelMapper.map(personSchoolClass, PersonSchoolClassResponse.class);
    }

    @Override
    public Iterable<PersonSchoolClassResponse> Get(boolean deleted) {
        Iterable<PersonSchoolClass> personsSchoolClasses;

        if (deleted) {
            personsSchoolClasses = personSchoolClassRepository.sp_PersonsSchoolClasses_GetDeleted();
        } else {
            personsSchoolClasses = personSchoolClassRepository.sp_PersonsSchoolClasses_Get();
        }

        return modelMapper.map(personsSchoolClasses, new TypeToken<Iterable<PersonSchoolClassResponse>>() {
        }.getType());
    }

    @Override
    public PersonSchoolClassResponse GetById(GetPersonSchoolClassRequest request) {
        PersonSchoolClass personSchoolClass = personSchoolClassRepository.sp_PersonsSchoolClasses_GetById(request.getId());
        return modelMapper.map(personSchoolClass, PersonSchoolClassResponse.class);
    }

    @Override
    public Iterable<PersonSchoolClassResponse> Search(SearchPersonSchoolClassRequest request) {
        Iterable<PersonSchoolClass> personsSchoolClasses = personSchoolClassRepository.sp_PersonsSchoolClasses_Search();
        return modelMapper.map(personsSchoolClasses, new TypeToken<Iterable<PersonSchoolClassResponse>>() {
        }.getType());
    }
}
