package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface SchoolClassRepository extends JpaRepository<SchoolClass, String> {
    @Procedure
    String sp_SchoolClass_Add(String name);

    @Procedure
    void sp_SchoolClass_Delete(String id);

    @Procedure
    void sp_SchoolClass_DeletePermanent(String id);

    @Procedure
    Iterable<SchoolClass> sp_SchoolClass_Get();

    @Procedure
    SchoolClass sp_SchoolClass_GetById(String id);

    @Procedure
    Iterable<SchoolClass> sp_SchoolClass_GetDeleted();

    @Procedure
    Iterable<SchoolClass> sp_SchoolClass_Search(String name);

    @Procedure
    void sp_SchoolClass_Undelete(String id);

    @Procedure
    void sp_SchoolClass_Update(String id, String name);
}
