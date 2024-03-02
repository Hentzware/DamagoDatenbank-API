package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ModuleRepository extends JpaRepository<Module, String> {
    @Procedure
    String sp_Module_Add(String name, String description);

    @Procedure
    void sp_Module_Delete(String id);

    @Procedure
    void sp_Module_DeletePermanent(String id);

    @Procedure
    Iterable<Module> sp_Module_Get();

    @Procedure
    Module sp_Module_GetById(String id);

    @Procedure
    Iterable<Module> sp_Module_GetDeleted();

    @Procedure
    Iterable<Module> sp_Module_Search(String name, String description);

    @Procedure
    void sp_Module_Undelete(String id);

    @Procedure
    void sp_Module_Update(String id, String name, String description);
}
