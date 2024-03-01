package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.repositories.PersonRepository;
import org.damago.damagodatenbankapi.requests.person.*;
import org.damago.damagodatenbankapi.responses.PersonResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final ModelMapper modelMapper;
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonResponse Add(AddPersonRequest request) {
        String id = personRepository.sp_Person_Add(request.getLast_name(), request.getFirst_name(), request.getBirthdate());
        Person person = personRepository.sp_Person_GetById(id);
        return modelMapper.map(person, PersonResponse.class);
    }

    @Override
    public void Delete(DeletePersonRequest request, boolean permanent) {
        if (permanent) {
            personRepository.sp_Person_DeletePermanent(request.getId());
            return;
        }
        personRepository.sp_Person_Delete(request.getId());
    }

    @Override
    public PersonResponse Edit(EditPersonRequest request) {
        personRepository.sp_Person_Update(request.getId(), request.getLast_name(), request.getFirst_name(), request.getBirthdate());
        Person person = personRepository.sp_Person_GetById(request.getId());
        return modelMapper.map(person, PersonResponse.class);
    }

    @Override
    public Iterable<PersonResponse> Get(boolean deleted) {
        Iterable<Person> persons;

        if (deleted) {
            persons = personRepository.sp_Person_GetDeleted();
        } else {
            persons = personRepository.sp_Person_Get();
        }

        return modelMapper.map(persons, new TypeToken<Iterable<PersonResponse>>() {
        }.getType());
    }

    @Override
    public PersonResponse GetById(GetPersonRequest request) {
        Person person = personRepository.sp_Person_GetById(request.getId());
        return modelMapper.map(person, PersonResponse.class);
    }

    @Override
    public Iterable<PersonResponse> Search(SearchPersonRequest request) {
        Iterable<Person> persons = personRepository.sp_Person_Search(request.getLast_name(), request.getFirst_name(), request.getBirthdate());
        return modelMapper.map(persons, new TypeToken<Iterable<PersonResponse>>() {
        }.getType());
    }
}
