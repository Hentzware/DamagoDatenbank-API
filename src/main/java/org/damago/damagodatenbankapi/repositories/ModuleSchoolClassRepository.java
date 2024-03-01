package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.ModuleSchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ModuleSchoolClassRepository extends JpaRepository<ModuleSchoolClass, String> {
    @Procedure
    String sp_ModulesSchoolClasses_Add();

    @Procedure
    void sp_ModulesSchoolClasses_Delete(String id);

    @Procedure
    void sp_ModulesSchoolClasses_DeletePermanent(String id);

    @Procedure
    Iterable<ModuleSchoolClass> sp_ModulesSchoolClasses_Get();

    @Procedure
    ModuleSchoolClass sp_ModulesSchoolClasses_GetById(String id);

    @Procedure
    Iterable<ModuleSchoolClass> sp_ModulesSchoolClasses_GetDeleted();

    @Procedure
    Iterable<ModuleSchoolClass> sp_ModulesSchoolClasses_Search();

    @Procedure
    void sp_ModulesSchoolClasses_Undelete(String id);

    @Procedure
    void sp_ModulesSchoolClasses_Update(String id);
}
