package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Adresse;
import org.damago.damagodatenbankapi.entities.PersonRolle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonRolleRepository extends JpaRepository<PersonRolle, String> {
    @Procedure
    String sp_PersonRole_Add(String personId, String rolleId);

    @Procedure
    void sp_PersonRole_Delete(String id);

    @Procedure
    void sp_PersonRole_DeletePermanent(String id);

    @Procedure
    Iterable<PersonRolle> sp_PersonRole_Get();

    @Procedure
    PersonRolle sp_PersonRole_GetById(String id);

    @Procedure
    Iterable<PersonRolle> sp_PersonRole_GetDeleted();

    @Procedure
    Iterable<PersonRolle> sp_PersonRole_Search(String personId, String rolleId);

    @Procedure
    void sp_PersonRole_Undelete(String id);

    @Procedure
    PersonRolle sp_PersonRole_Update(String id, String personId, String rolleId);
}
