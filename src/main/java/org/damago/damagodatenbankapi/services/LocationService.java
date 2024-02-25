package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.location.*;
import org.damago.damagodatenbankapi.responses.LocationResponse;

public interface LocationService {
    LocationResponse Add(AddLocationRequest request);

    void Delete(DeleteLocationRequest request, boolean permanent);

    LocationResponse Edit(EditLocationRequest request);

    Iterable<LocationResponse> Get(boolean deleted);

    LocationResponse GetById(GetLocationRequest request);

    Iterable<LocationResponse> Search(SearchLocationRequest request);
}
