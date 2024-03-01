package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface RoleRepository extends JpaRepository<Role, String> {
    @Procedure
    String sp_Roles_Add();

    @Procedure
    void sp_Roles_Delete(String id);

    @Procedure
    void sp_Roles_DeletePermanent(String id);

    @Procedure
    Iterable<Role> sp_Roles_Get();

    @Procedure
    Role sp_Roles_GetById(String id);

    @Procedure
    Iterable<Role> sp_Roles_GetDeleted();

    @Procedure
    Iterable<Role> sp_Roles_Search();

    @Procedure
    void sp_Roles_Undelete(String id);

    @Procedure
    void sp_Roles_Update(String id);
}
