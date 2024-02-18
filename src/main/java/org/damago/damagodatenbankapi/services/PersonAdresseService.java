package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.personAdresse.*;
import org.damago.damagodatenbankapi.responses.PersonAdresseResponse;

public interface PersonAdresseService {
    PersonAdresseResponse Add(AddPersonAdresseRequest request);

    void Delete(DeletePersonAdresseRequest request, boolean permanent);

    PersonAdresseResponse Edit(EditPersonAdresseRequest request);

    Iterable<PersonAdresseResponse> Get(boolean deleted);

    PersonAdresseResponse GetById(GetPersonAdresseRequest request);

    Iterable<PersonAdresseResponse> Search(SearchPersonAdresseRequest request);
}
