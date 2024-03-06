package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.locationSchoolClass.*;
import org.damago.damagodatenbankapi.responses.LocationSchoolClassResponse;

public interface LocationSchoolClassService {
    LocationSchoolClassResponse Add(AddLocationSchoolClassRequest request);

    void Delete(DeleteLocationSchoolClassRequest request, boolean permanent);

    LocationSchoolClassResponse Edit(EditLocationSchoolClassRequest request);

    Iterable<LocationSchoolClassResponse> Get(boolean deleted);

    LocationSchoolClassResponse GetById(GetLocationSchoolClassRequest request);

    Iterable<LocationSchoolClassResponse> Search(SearchLocationSchoolClassRequest request);
}
