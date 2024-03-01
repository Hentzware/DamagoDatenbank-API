package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonRoleRepository extends JpaRepository<PersonRole, String> {
    @Procedure
    String sp_PersonsRoles_Add();

    @Procedure
    void sp_PersonsRoles_Delete(String id);

    @Procedure
    void sp_PersonsRoles_DeletePermanent(String id);

    @Procedure
    Iterable<PersonRole> sp_PersonsRoles_Get();

    @Procedure
    PersonRole sp_PersonsRoles_GetById(String id);

    @Procedure
    Iterable<PersonRole> sp_PersonsRoles_GetDeleted();

    @Procedure
    Iterable<PersonRole> sp_PersonsRoles_Search();

    @Procedure
    void sp_PersonsRoles_Undelete(String id);

    @Procedure
    void sp_PersonsRoles_Update(String id);
}
