package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.DeletePersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.requests.person.GetPersonRequest;
import org.damago.damagodatenbankapi.responses.PersonResponse;

import java.util.Date;

public interface PersonService {
    PersonResponse Add(AddPersonRequest request);

    void Delete(DeletePersonRequest request, boolean permanent);

    PersonResponse Edit(EditPersonRequest request);

    Iterable<PersonResponse> Get(boolean deleted);

    PersonResponse GetById(GetPersonRequest request);

    Iterable<PersonResponse> Search(String nachname, String vorname, Date geburtsdatum);
}
