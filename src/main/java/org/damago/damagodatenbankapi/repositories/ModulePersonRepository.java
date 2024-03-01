package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.ModulePerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ModulePersonRepository extends JpaRepository<ModulePerson, String> {
    @Procedure
    String sp_ModulesPersons_Add();

    @Procedure
    void sp_ModulesPersons_Delete(String id);

    @Procedure
    void sp_ModulesPersons_DeletePermanent(String id);

    @Procedure
    Iterable<ModulePerson> sp_ModulesPersons_Get();

    @Procedure
    ModulePerson sp_ModulesPersons_GetById(String id);

    @Procedure
    Iterable<ModulePerson> sp_ModulesPersons_GetDeleted();

    @Procedure
    Iterable<ModulePerson> sp_ModulesPersons_Search();

    @Procedure
    void sp_ModulesPersons_Undelete(String id);

    @Procedure
    void sp_ModulesPersons_Update(String id);
}
