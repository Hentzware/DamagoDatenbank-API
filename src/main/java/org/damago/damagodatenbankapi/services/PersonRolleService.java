package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.personRolle.*;
import org.damago.damagodatenbankapi.responses.PersonRolleResponse;

public interface PersonRolleService {
    PersonRolleResponse Add(AddPersonRolleRequest request);

    void Delete(DeletePersonRolleRequest request, boolean permanent);

    PersonRolleResponse Edit(EditPersonRolleRequest request);

    Iterable<PersonRolleResponse> Get(boolean deleted);

    PersonRolleResponse GetById(GetPersonRolleRequest request);

    Iterable<PersonRolleResponse> Search(SearchPersonRolleRequest request);
}
