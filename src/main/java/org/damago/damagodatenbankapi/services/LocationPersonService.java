package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.locationPerson.*;
import org.damago.damagodatenbankapi.responses.LocationPersonResponse;

public interface LocationPersonService {
    LocationPersonResponse Add(AddLocationPersonRequest request);

    void Delete(DeleteLocationPersonRequest request, boolean permanent);

    LocationPersonResponse Edit(EditLocationPersonRequest request);

    Iterable<LocationPersonResponse> Get(boolean deleted);

    LocationPersonResponse GetById(GetLocationPersonRequest request);

    Iterable<LocationPersonResponse> Search(SearchLocationPersonRequest request);
}
