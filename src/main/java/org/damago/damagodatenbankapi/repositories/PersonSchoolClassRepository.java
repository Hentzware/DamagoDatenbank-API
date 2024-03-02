package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonSchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonSchoolClassRepository extends JpaRepository<PersonSchoolClass, String> {
    @Procedure
    String sp_PersonSchoolClass_Add(String person_id, String school_class_id);

    @Procedure
    void sp_PersonSchoolClass_Delete(String id);

    @Procedure
    void sp_PersonSchoolClass_DeletePermanent(String id);

    @Procedure
    Iterable<PersonSchoolClass> sp_PersonSchoolClass_Get();

    @Procedure
    PersonSchoolClass sp_PersonSchoolClass_GetById(String id);

    @Procedure
    Iterable<PersonSchoolClass> sp_PersonSchoolClass_GetDeleted();

    @Procedure
    Iterable<PersonSchoolClass> sp_PersonSchoolClass_Search(String person_id, String school_class_id);

    @Procedure
    void sp_PersonSchoolClass_Undelete(String id);

    @Procedure
    void sp_PersonSchoolClass_Update(String id, String person_id, String school_class_id);
}
