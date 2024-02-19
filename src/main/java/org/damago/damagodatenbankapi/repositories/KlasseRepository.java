package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Klasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface KlasseRepository extends JpaRepository<Klasse, String> {
    @Procedure
    String sp_Classes_Add(String name);

    @Procedure
    void sp_Classes_Delete(String id);

    @Procedure
    void sp_Classes_DeletePermanent(String id);

    @Procedure
    Iterable<Klasse> sp_Classes_Get();

    @Procedure
    Klasse sp_Classes_GetById(String id);

    @Procedure
    Iterable<Klasse> sp_Classes_GetDeleted();

    @Procedure
    Iterable<Klasse> sp_Classes_Search(String name);

    @Procedure
    void sp_Classes_Undelete(String id);

    @Procedure
    void sp_Classes_Update(String id, String name);
}
