package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.raum.*;
import org.damago.damagodatenbankapi.responses.RaumResponse;

public interface RaumService {
    RaumResponse Add(AddRaumRequest request);

    void Delete(DeleteRaumRequest request, boolean permanent);

    RaumResponse Edit(EditRaumRequest request);

    Iterable<RaumResponse> Get(boolean deleted);

    RaumResponse GetById(GetRaumRequest request);

    Iterable<RaumResponse> Search(SearchRaumRequest request);
}
