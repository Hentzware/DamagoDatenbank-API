package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.personRole.*;
import org.damago.damagodatenbankapi.responses.PersonRoleResponse;

public interface PersonRoleService {
    PersonRoleResponse Add(AddPersonRoleRequest request);

    void Delete(DeletePersonRoleRequest request, boolean permanent);

    PersonRoleResponse Edit(EditPersonRoleRequest request);

    Iterable<PersonRoleResponse> Get(boolean deleted);

    PersonRoleResponse GetById(GetPersonRoleRequest request);

    Iterable<PersonRoleResponse> Search(SearchPersonRoleRequest request);
}
