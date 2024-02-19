package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Raum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface RaumRepository extends JpaRepository<Raum, String> {
    @Procedure
    String sp_Rooms_Add(String name, String nr);

    @Procedure
    void sp_Rooms_Delete(String id);

    @Procedure
    void sp_Rooms_DeletePermanent(String id);

    @Procedure
    Iterable<Raum> sp_Rooms_Get();

    @Procedure
    Raum sp_Rooms_GetById(String id);

    @Procedure
    Iterable<Raum> sp_Rooms_GetDeleted();

    @Procedure
    Iterable<Raum> sp_Rooms_Search(String name, String nr);

    @Procedure
    void sp_Rooms_Undelete(String id);

    @Procedure
    void sp_Rooms_Update(String id, String name, String nr);
}
