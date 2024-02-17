package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.repositories.PersonRepository;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.DeletePersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.requests.person.GetPersonRequest;
import org.damago.damagodatenbankapi.responses.PersonResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonServiceImpl implements PersonService {

    private final ModelMapper modelMapper;
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper, ModelMapper modelMapper1) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonResponse Add(AddPersonRequest request) {
        String id = personRepository.sp_Persons_Add(request.getNachname(), request.getVorname(), request.getGeburtsdatum());
        Person person = personRepository.sp_Persons_GetById(id);
        return modelMapper.map(person, PersonResponse.class);
    }

    @Override
    public void Delete(DeletePersonRequest request, boolean permanent) {
        if (permanent) {
            personRepository.sp_Persons_DeletePermanent(request.getId());
            return;
        }
        personRepository.sp_Persons_Delete(request.getId());
    }

    @Override
    public PersonResponse Edit(EditPersonRequest request) {
        personRepository.sp_Persons_Update(request.getId(), request.getNachname(), request.getVorname(), request.getGeburtsdatum());
        Person person = personRepository.sp_Persons_GetById(request.getId());
        return modelMapper.map(person, PersonResponse.class);
    }

    @Override
    public Iterable<PersonResponse> Get(boolean deleted) {
        Iterable<Person> persons;

        if (deleted) {
            persons = personRepository.sp_Persons_GetDeleted();
        } else {
            persons = personRepository.sp_Persons_Get();
        }

        return modelMapper.map(persons, new TypeToken<Iterable<PersonResponse>>() {
        }.getType());
    }

    @Override
    public PersonResponse GetById(GetPersonRequest request) {
        Person person = personRepository.sp_Persons_GetById(request.getId());
        return modelMapper.map(person, PersonResponse.class);
    }

    @Override
    public Iterable<PersonResponse> Search(String nachname, String vorname, Date geburtsdatum) {
        Iterable<Person> persons = personRepository.sp_Persons_Search(nachname, vorname, geburtsdatum);
        return modelMapper.map(persons, new TypeToken<Iterable<PersonResponse>>() {
        }.getType());
    }
}
