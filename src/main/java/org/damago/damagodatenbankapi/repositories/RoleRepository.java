package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface RoleRepository extends JpaRepository<Role, String> {
    @Procedure
    String sp_Role_Add(String name);

    @Procedure
    void sp_Role_Delete(String id);

    @Procedure
    void sp_Role_DeletePermanent(String id);

    @Procedure
    Iterable<Role> sp_Role_Get();

    @Procedure
    Role sp_Role_GetById(String id);

    @Procedure
    Iterable<Role> sp_Role_GetDeleted();

    @Procedure
    Iterable<Role> sp_Role_Search(String name);

    @Procedure
    void sp_Role_Undelete(String id);

    @Procedure
    void sp_Role_Update(String id, String name);
}
