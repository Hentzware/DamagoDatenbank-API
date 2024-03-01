package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.schoolClass.*;
import org.damago.damagodatenbankapi.responses.SchoolClassResponse;

public interface SchoolClassService {
    SchoolClassResponse Add(AddSchoolClassRequest request);

    void Delete(DeleteSchoolClassRequest request, boolean permanent);

    SchoolClassResponse Edit(EditSchoolClassRequest request);

    Iterable<SchoolClassResponse> Get(boolean deleted);

    SchoolClassResponse GetById(GetSchoolClassRequest request);

    Iterable<SchoolClassResponse> Search(SearchSchoolClassRequest request);
}
