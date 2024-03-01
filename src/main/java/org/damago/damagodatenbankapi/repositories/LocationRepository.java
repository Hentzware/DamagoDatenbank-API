package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface LocationRepository extends JpaRepository<Location, String> {
    @Procedure
    String sp_Locations_Add(String name);

    @Procedure
    void sp_Locations_Delete(String id);

    @Procedure
    void sp_Locations_DeletePermanent(String id);

    @Procedure
    Iterable<Location> sp_Locations_Get();

    @Procedure
    Location sp_Locations_GetById(String id);

    @Procedure
    Iterable<Location> sp_Locations_GetDeleted();

    @Procedure
    Iterable<Location> sp_Locations_Search(String name);

    @Procedure
    void sp_Locations_Update(String id, String name);
}
