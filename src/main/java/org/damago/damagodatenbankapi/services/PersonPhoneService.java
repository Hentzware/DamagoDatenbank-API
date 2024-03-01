package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.personPhone.*;
import org.damago.damagodatenbankapi.responses.PersonPhoneResponse;

public interface PersonPhoneService {
    PersonPhoneResponse Add(AddPersonPhoneRequest request);

    void Delete(DeletePersonPhoneRequest request, boolean permanent);

    PersonPhoneResponse Edit(EditPersonPhoneRequest request);

    Iterable<PersonPhoneResponse> Get(boolean deleted);

    PersonPhoneResponse GetById(GetPersonPhoneRequest request);

    Iterable<PersonPhoneResponse> Search(SearchPersonPhoneRequest request);
}
