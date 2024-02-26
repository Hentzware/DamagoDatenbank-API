package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Modul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ModulRepository extends JpaRepository<Modul,String > {
    @Procedure
    String sp_Modules_Add(String name, String beschreibung);

    @Procedure
    void sp_Modules_Delete(String id);

    @Procedure
    void sp_Modules_DeletePermanent(String id);

    @Procedure
    Iterable<Modul> sp_Modules_Get();

    @Procedure
    Modul sp_Modules_GetById(String id);

    @Procedure
    Iterable<Modul> sp_Modules_GetDeleted();

    @Procedure
    Iterable<Modul> sp_Modules_Search(String name);

    @Procedure
    void sp_Module_Undelete(String id);

    @Procedure
    void sp_Modules_Update(String id, String name, String beschreibung);
}
