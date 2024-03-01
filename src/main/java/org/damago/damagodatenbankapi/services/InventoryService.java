package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.inventory.*;
import org.damago.damagodatenbankapi.responses.InventoryResponse;

public interface InventoryService {
    InventoryResponse Add(AddInventoryRequest request);

    void Delete(DeleteInventoryRequest request, boolean permanent);

    InventoryResponse Edit(EditInventoryRequest request);

    Iterable<InventoryResponse> Get(boolean deleted);

    InventoryResponse GetById(GetInventoryRequest request);

    Iterable<InventoryResponse> Search(SearchInventoryRequest request);
}
