package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.modul.*;
import org.damago.damagodatenbankapi.responses.ModulResponse;

public interface ModulService {
    ModulResponse Add(AddModulRequest request);

    void Delete(DeleteModulRequest request, boolean permanent);

    ModulResponse Edit(EditModulRequest request);

    Iterable<ModulResponse> Get(boolean deleted);

    ModulResponse GetById(GetModulRequest request);

    Iterable<ModulResponse> Search(SearchModulRequest request);
}

