package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface RoomRepository extends JpaRepository<Room, String> {
    @Procedure
    String sp_Room_Add(String name, String nr);

    @Procedure
    void sp_Room_Delete(String id);

    @Procedure
    void sp_Room_DeletePermanent(String id);

    @Procedure
    Iterable<Room> sp_Room_Get();

    @Procedure
    Room sp_Room_GetById(String id);

    @Procedure
    Iterable<Room> sp_Room_GetDeleted();

    @Procedure
    Iterable<Room> sp_Room_Search(String name, String nr);

    @Procedure
    void sp_Room_Undelete(String id);

    @Procedure
    void sp_Room_Update(String id, String name, String nr);
}
