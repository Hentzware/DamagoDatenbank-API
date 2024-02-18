package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonStandort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonStandortRepository extends JpaRepository<PersonStandort, String> {
    @Procedure
    String sp_PersonLocation_Add(String personId, String standortId);

    @Procedure
    void sp_PersonLocation_Delete(String id);

    @Procedure
    void sp_PersonLocation_DeletePermanent(String id);

    @Procedure
    Iterable<PersonStandort> sp_PersonLocation_Get();

    @Procedure
    PersonStandort sp_PersonLocation_GetById(String id);

    @Procedure
    Iterable<PersonStandort> sp_PersonLocation_GetDeleted();

    @Procedure
    Iterable<PersonStandort> sp_PersonLocation_Search(String personId, String standortId);

    @Procedure
    void sp_PersonLocation_Undelete(String id);

    @Procedure
    void sp_PersonLocation_Update(String id, String personId, String standortId);
}
