package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.module.*;
import org.damago.damagodatenbankapi.responses.ModuleResponse;

public interface ModuleService {
    ModuleResponse Add(AddModuleRequest request);

    void Delete(DeleteModuleRequest request, boolean permanent);

    ModuleResponse Edit(EditModuleRequest request);

    Iterable<ModuleResponse> Get(boolean deleted);

    ModuleResponse GetById(GetModuleRequest request);

    Iterable<ModuleResponse> Search(SearchModuleRequest request);
}
