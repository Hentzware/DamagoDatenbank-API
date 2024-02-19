package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.personKlasse.*;
import org.damago.damagodatenbankapi.responses.PersonKlasseResponse;

public interface PersonKlasseService {
    PersonKlasseResponse Add(AddPersonKlasseRequest request);

    void Delete(DeletePersonKlasseRequest request, boolean permanent);

    PersonKlasseResponse Edit(EditPersonKlasseRequest request);

    Iterable<PersonKlasseResponse> Get(boolean deleted);

    PersonKlasseResponse GetById(GetPersonKlasseRequest request);

    Iterable<PersonKlasseResponse> Search(SearchPersonKlasseRequest request);
}
