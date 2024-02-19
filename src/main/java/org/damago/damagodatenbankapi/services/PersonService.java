package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.person.*;
import org.damago.damagodatenbankapi.responses.PersonResponse;

import java.util.Date;

public interface PersonService {
    PersonResponse Add(AddPersonRequest request);

    void Delete(DeletePersonRequest request, boolean permanent);

    PersonResponse Edit(EditPersonRequest request);

    Iterable<PersonResponse> Get(boolean deleted);

    PersonResponse GetById(GetPersonRequest request);

    Iterable<PersonResponse> Search(SearchPersonRequest request);
}
