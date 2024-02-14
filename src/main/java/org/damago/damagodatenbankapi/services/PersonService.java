package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.DeletePersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.requests.person.GetPersonRequest;
import org.damago.damagodatenbankapi.responses.PersonResponse;

public interface PersonService {
    public Iterable<PersonResponse> Get();
    public PersonResponse Get(GetPersonRequest request);
    public PersonResponse Add(AddPersonRequest request);
    public PersonResponse Edit(EditPersonRequest request);
    public PersonResponse Delete(DeletePersonRequest request);
}
