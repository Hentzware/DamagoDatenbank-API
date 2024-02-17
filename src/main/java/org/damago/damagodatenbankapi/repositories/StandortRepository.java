package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Standort;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface StandortRepository {
    @Procedure
    String sp_Locations_Add(String name);

    @Procedure
    void sp_Locations_Delete(String id);

    @Procedure
    void sp_Locations_DeletePermanent(String id);

    @Procedure
    Iterable<Standort> sp_Locations_Get();

    @Procedure
    Standort sp_Locations_GetById(String id);

    @Procedure
    Iterable<Standort> sp_Locations_GetDeleted();

    @Procedure
    Iterable<Standort> sp_Locations_Search(String name);

    @Procedure
    void sp_Locations_Update(String id, String name);
}
