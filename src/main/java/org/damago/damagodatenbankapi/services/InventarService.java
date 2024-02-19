package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.inventar.*;
import org.damago.damagodatenbankapi.responses.InventarResponse;

public interface InventarService {
    InventarResponse Add(AddInventarRequest request);

    void Delete(DeleteInventarRequest request, boolean permanent);

    InventarResponse Edit(EditInventarRequest request);

    Iterable<InventarResponse> Get(boolean deleted);

    InventarResponse GetById(GetInventarRequest request);

    Iterable<InventarResponse> Search(SearchInventarRequest request);
}
