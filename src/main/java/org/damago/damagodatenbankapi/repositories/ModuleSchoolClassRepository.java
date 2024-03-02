package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.ModuleSchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ModuleSchoolClassRepository extends JpaRepository<ModuleSchoolClass, String> {
    @Procedure
    String sp_ModuleSchoolClass_Add(String module_id, String school_class_id);

    @Procedure
    void sp_ModuleSchoolClass_Delete(String id);

    @Procedure
    void sp_ModuleSchoolClass_DeletePermanent(String id);

    @Procedure
    Iterable<ModuleSchoolClass> sp_ModuleSchoolClass_Get();

    @Procedure
    ModuleSchoolClass sp_ModuleSchoolClass_GetById(String id);

    @Procedure
    Iterable<ModuleSchoolClass> sp_ModuleSchoolClass_GetDeleted();

    @Procedure
    Iterable<ModuleSchoolClass> sp_ModuleSchoolClass_Search(String module_id, String school_class_id);

    @Procedure
    void sp_ModuleSchoolClass_Undelete(String id);

    @Procedure
    void sp_ModuleSchoolClass_Update(String id, String module_id, String school_class_id);
}
