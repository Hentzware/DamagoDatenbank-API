package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.moduleSchoolClass.*;
import org.damago.damagodatenbankapi.responses.ModuleSchoolClassResponse;

public interface ModuleSchoolClassService {
    ModuleSchoolClassResponse Add(AddModuleSchoolClassRequest request);

    void Delete(DeleteModuleSchoolClassRequest request, boolean permanent);

    ModuleSchoolClassResponse Edit(EditModuleSchoolClassRequest request);

    Iterable<ModuleSchoolClassResponse> Get(boolean deleted);

    ModuleSchoolClassResponse GetById(GetModuleSchoolClassRequest request);

    Iterable<ModuleSchoolClassResponse> Search(SearchModuleSchoolClassRequest request);
}
