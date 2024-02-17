package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Klasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

public interface KlasseRepository extends JpaRepository<Klasse, String> {
    @Procedure
    @Transactional(readOnly = true)
    Klasse sp_Classes_Add(String name, String nr);

    @Procedure
    @Transactional(readOnly = true)
    void sp_Classes_Delete(String id);

    @Procedure
    @Transactional(readOnly = true)
    void sp_Classes_DeletePermanent(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Klasse> sp_Classes_Get();

    @Procedure
    @Transactional(readOnly = true)
    Klasse sp_Classes_GetById(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Klasse> sp_Classes_GetByName(String name);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Klasse> sp_Classes_GetByNr(String nr);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Klasse> sp_Classes_GetDeleted();

    @Procedure
    @Transactional(readOnly = true)
    void sp_Classes_Undelete(String id);

    @Procedure
    @Transactional(readOnly = true)
    Klasse sp_Classes_Update(String id, String name, String nr);
}
