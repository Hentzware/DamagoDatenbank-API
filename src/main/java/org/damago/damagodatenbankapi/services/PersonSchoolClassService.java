package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.personSchoolClass.*;
import org.damago.damagodatenbankapi.responses.PersonSchoolClassResponse;

public interface PersonSchoolClassService {
    PersonSchoolClassResponse Add(AddPersonSchoolClassRequest request);

    void Delete(DeletePersonSchoolClassRequest request, boolean permanent);

    PersonSchoolClassResponse Edit(EditPersonSchoolClassRequest request);

    Iterable<PersonSchoolClassResponse> Get(boolean deleted);

    PersonSchoolClassResponse GetById(GetPersonSchoolClassRequest request);

    Iterable<PersonSchoolClassResponse> Search(SearchPersonSchoolClassRequest request);
}
