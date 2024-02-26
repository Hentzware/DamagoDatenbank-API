package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface SchoolClassRepository extends JpaRepository<SchoolClass, String> {
    @Procedure
    String sp_SchoolClasses_Add(String name);

    @Procedure
    void sp_SchoolClasses_Delete(String id);

    @Procedure
    void sp_SchoolClasses_DeletePermanent(String id);

    @Procedure
    Iterable<SchoolClass> sp_SchoolClasses_Get();

    @Procedure
    SchoolClass sp_SchoolClasses_GetById(String id);

    @Procedure
    Iterable<SchoolClass> sp_SchoolClasses_GetDeleted();

    @Procedure
    Iterable<SchoolClass> sp_SchoolClasses_Search(String name);

    @Procedure
    void sp_SchoolClasses_Undelete(String id);

    @Procedure
    void sp_SchoolClasses_Update(String id, String name);
}
