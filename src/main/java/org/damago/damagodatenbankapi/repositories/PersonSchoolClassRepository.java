package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonSchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonSchoolClassRepository extends JpaRepository<PersonSchoolClass, String> {
    @Procedure
    String sp_PersonsSchoolClasses_Add();

    @Procedure
    void sp_PersonsSchoolClasses_Delete(String id);

    @Procedure
    void sp_PersonsSchoolClasses_DeletePermanent(String id);

    @Procedure
    Iterable<PersonSchoolClass> sp_PersonsSchoolClasses_Get();

    @Procedure
    PersonSchoolClass sp_PersonsSchoolClasses_GetById(String id);

    @Procedure
    Iterable<PersonSchoolClass> sp_PersonsSchoolClasses_GetDeleted();

    @Procedure
    Iterable<PersonSchoolClass> sp_PersonsSchoolClasses_Search();

    @Procedure
    void sp_PersonsSchoolClasses_Undelete(String id);

    @Procedure
    void sp_PersonsSchoolClasses_Update(String id);
}
