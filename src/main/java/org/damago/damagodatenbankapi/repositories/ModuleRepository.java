package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ModuleRepository extends JpaRepository<Module, String> {
    @Procedure
    String sp_Modules_Add();

    @Procedure
    void sp_Modules_Delete(String id);

    @Procedure
    void sp_Modules_DeletePermanent(String id);

    @Procedure
    Iterable<Module> sp_Modules_Get();

    @Procedure
    Module sp_Modules_GetById(String id);

    @Procedure
    Iterable<Module> sp_Modules_GetDeleted();

    @Procedure
    Iterable<Module> sp_Modules_Search();

    @Procedure
    void sp_Modules_Undelete(String id);

    @Procedure
    void sp_Modules_Update(String id);
}
