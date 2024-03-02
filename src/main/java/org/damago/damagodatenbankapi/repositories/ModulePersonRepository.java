package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.ModulePerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ModulePersonRepository extends JpaRepository<ModulePerson, String> {
    @Procedure
    String sp_ModulePerson_Add(String module_id, String person_id);

    @Procedure
    void sp_ModulePerson_Delete(String id);

    @Procedure
    void sp_ModulePerson_DeletePermanent(String id);

    @Procedure
    Iterable<ModulePerson> sp_ModulePerson_Get();

    @Procedure
    ModulePerson sp_ModulePerson_GetById(String id);

    @Procedure
    Iterable<ModulePerson> sp_ModulePerson_GetDeleted();

    @Procedure
    Iterable<ModulePerson> sp_ModulePerson_Search(String module_id, String person_id);

    @Procedure
    void sp_ModulePerson_Undelete(String id);

    @Procedure
    void sp_ModulePerson_Update(String id, String module_id, String person_id);
}
