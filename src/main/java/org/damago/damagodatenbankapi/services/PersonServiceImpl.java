package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.DeletePersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.requests.person.GetPersonRequest;
import org.damago.damagodatenbankapi.responses.PersonResponse;

public class PersonServiceImpl implements PersonService {

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
