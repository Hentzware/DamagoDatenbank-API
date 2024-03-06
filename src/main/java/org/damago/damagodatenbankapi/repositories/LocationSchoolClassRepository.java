package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.LocationSchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface LocationSchoolClassRepository extends JpaRepository<LocationSchoolClass, String> {
    @Procedure
    String sp_LocationSchoolClass_Add();

    @Procedure
    void sp_LocationSchoolClass_Delete(String id);

    @Procedure
    void sp_LocationSchoolClass_DeletePermanent(String id);

    @Procedure
    Iterable<LocationSchoolClass> sp_LocationSchoolClass_Get();

    @Procedure
    LocationSchoolClass sp_LocationSchoolClass_GetById(String id);

    @Procedure
    Iterable<LocationSchoolClass> sp_LocationSchoolClass_GetDeleted();

    @Procedure
    Iterable<LocationSchoolClass> sp_LocationSchoolClass_Search();

    @Procedure
    void sp_LocationSchoolClass_Undelete(String id);

    @Procedure
    void sp_LocationSchoolClass_Update(String id);
}
