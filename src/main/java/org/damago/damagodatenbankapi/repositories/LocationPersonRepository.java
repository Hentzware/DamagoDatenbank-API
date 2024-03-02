package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.LocationPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface LocationPersonRepository extends JpaRepository<LocationPerson, String> {
    @Procedure
    String sp_LocationPerson_Add(String location_id, String person_id);

    @Procedure
    void sp_LocationPerson_Delete(String id);

    @Procedure
    void sp_LocationPerson_DeletePermanent(String id);

    @Procedure
    Iterable<LocationPerson> sp_LocationPerson_Get();

    @Procedure
    LocationPerson sp_LocationPerson_GetById(String id);

    @Procedure
    Iterable<LocationPerson> sp_LocationPerson_GetDeleted();

    @Procedure
    Iterable<LocationPerson> sp_LocationPerson_Search(String location_id, String person_id);

    @Procedure
    void sp_LocationPerson_Undelete(String id);

    @Procedure
    void sp_LocationPerson_Update(String id, String location_id, String person_id);
}
