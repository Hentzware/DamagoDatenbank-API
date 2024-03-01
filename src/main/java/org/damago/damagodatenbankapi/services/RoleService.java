package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.role.*;
import org.damago.damagodatenbankapi.responses.RoleResponse;

public interface RoleService {
    RoleResponse Add(AddRoleRequest request);

    void Delete(DeleteRoleRequest request, boolean permanent);

    RoleResponse Edit(EditRoleRequest request);

    Iterable<RoleResponse> Get(boolean deleted);

    RoleResponse GetById(GetRoleRequest request);

    Iterable<RoleResponse> Search(SearchRoleRequest request);
}
