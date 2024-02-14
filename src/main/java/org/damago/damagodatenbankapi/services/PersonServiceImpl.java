package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.repositories.PersonRepository;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.DeletePersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.requests.person.GetPersonRequest;
import org.damago.damagodatenbankapi.responses.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService {
    PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Iterable<PersonResponse> Get() {
        return null;
    }

    @Override
    public PersonResponse Get(GetPersonRequest request) {
        return null;
    }

    @Override
    public PersonResponse Add(AddPersonRequest request) {
        return null;
    }

    @Override
    public PersonResponse Edit(EditPersonRequest request) {
        return null;
    }

    @Override
    public PersonResponse Delete(DeletePersonRequest request) {
        return null;
    }
}
