package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.standort.*;
import org.damago.damagodatenbankapi.responses.StandortResponse;

public interface StandortService {
    StandortResponse Add(AddStandortRequest request);

    void Delete(DeleteStandortRequest request, boolean permanent);

    StandortResponse Edit(EditStandortRequest request);

    Iterable<StandortResponse> Get(boolean deleted);

    StandortResponse GetById(GetStandortRequest request);

    Iterable<StandortResponse> Search(SearchStandortRequest request);
}
