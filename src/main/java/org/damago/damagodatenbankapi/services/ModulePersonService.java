package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.modulePerson.*;
import org.damago.damagodatenbankapi.responses.ModulePersonResponse;

public interface ModulePersonService {
    ModulePersonResponse Add(AddModulePersonRequest request);

    void Delete(DeleteModulePersonRequest request, boolean permanent);

    ModulePersonResponse Edit(EditModulePersonRequest request);

    Iterable<ModulePersonResponse> Get(boolean deleted);

    ModulePersonResponse GetById(GetModulePersonRequest request);

    Iterable<ModulePersonResponse> Search(SearchModulePersonRequest request);
}
