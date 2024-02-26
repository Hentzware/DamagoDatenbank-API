package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Modul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ModulRepository extends JpaRepository<Modul,String > {
    @Procedure
    String sp_Module_Add(String name, String dauer);

    @Procedure
    void sp_Module_Delete(String id);

    @Procedure
    void sp_Module_DeletePermanent(String id);

    @Procedure
    Iterable<Modul> sp_Module_Get();

    @Procedure
    Modul sp_Module_GetById(String id);

    @Procedure
    Iterable<Modul> sp_Module_GetDeleted();

    @Procedure
    Iterable<Modul> sp_Module_Search(String name);

    @Procedure
    void sp_Module_Undelete(String id);

    @Procedure
    void sp_Module_Update(String id, String name, String dauer);
}
