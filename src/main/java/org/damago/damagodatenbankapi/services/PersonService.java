package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.DeletePersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.requests.person.GetPersonRequest;
import org.damago.damagodatenbankapi.responses.PersonResponse;

public interface PersonService {
    Iterable<PersonResponse> Get();
    PersonResponse Get(GetPersonRequest request);
    PersonResponse Add(AddPersonRequest request);
    PersonResponse Edit(EditPersonRequest request);
    PersonResponse Delete(DeletePersonRequest request);
}
