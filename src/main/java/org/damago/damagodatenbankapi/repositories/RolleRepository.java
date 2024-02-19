package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Rolle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface RolleRepository extends JpaRepository<Rolle, String> {
    @Procedure
    String sp_Roles_Add(String name);

    @Procedure
    void sp_Roles_Delete(String id);

    @Procedure
    void sp_Roles_DeletePermanent(String id);

    @Procedure
    Iterable<Rolle> sp_Roles_Get();

    @Procedure
    Rolle sp_Roles_GetById(String id);

    @Procedure
    Iterable<Rolle> sp_Roles_GetDeleted();

    @Procedure
    Iterable<Rolle> sp_Roles_Search(String name);

    @Procedure
    void sp_Roles_Update(String id, String name);
}
