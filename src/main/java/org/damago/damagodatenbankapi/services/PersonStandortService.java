package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.personStandort.*;
import org.damago.damagodatenbankapi.responses.PersonStandortResponse;

public interface PersonStandortService {
    PersonStandortResponse Add(AddPersonStandortRequest request);

    void Delete(DeletePersonStandortRequest request, boolean permanent);

    PersonStandortResponse Edit(EditPersonStandortRequest request);

    Iterable<PersonStandortResponse> Get(boolean deleted);

    PersonStandortResponse GetById(GetPersonStandortRequest request);

    Iterable<PersonStandortResponse> Search(SearchPersonStandortRequest request);
}
