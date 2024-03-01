package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface RoomRepository extends JpaRepository<Room, String> {
    @Procedure
    String sp_Rooms_Add();

    @Procedure
    void sp_Rooms_Delete(String id);

    @Procedure
    void sp_Rooms_DeletePermanent(String id);

    @Procedure
    Iterable<Room> sp_Rooms_Get();

    @Procedure
    Room sp_Rooms_GetById(String id);

    @Procedure
    Iterable<Room> sp_Rooms_GetDeleted();

    @Procedure
    Iterable<Room> sp_Rooms_Search();

    @Procedure
    void sp_Rooms_Undelete(String id);

    @Procedure
    void sp_Rooms_Update(String id);
}
