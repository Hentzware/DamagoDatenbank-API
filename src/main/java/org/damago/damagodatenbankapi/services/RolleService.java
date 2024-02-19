package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.rolle.*;
import org.damago.damagodatenbankapi.responses.RolleResponse;

public interface RolleService {
    RolleResponse Add(AddRolleRequest request);

    void Delete(DeleteRolleRequest request, boolean permanent);

    RolleResponse Edit(EditRolleRequest request);

    Iterable<RolleResponse> Get(boolean deleted);

    RolleResponse GetById(GetRolleRequest request);

    Iterable<RolleResponse> Search(SearchRolleRequest request);
}
