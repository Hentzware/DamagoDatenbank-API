package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonPhoneRepository extends JpaRepository<PersonPhone, String> {
    @Procedure
    String sp_PersonPhone_Add(String person_id, String phone_id);

    @Procedure
    void sp_PersonPhone_Delete(String id);

    @Procedure
    void sp_PersonPhone_DeletePermanent(String id);

    @Procedure
    Iterable<PersonPhone> sp_PersonPhone_Get();

    @Procedure
    PersonPhone sp_PersonPhone_GetById(String id);

    @Procedure
    Iterable<PersonPhone> sp_PersonPhone_GetDeleted();

    @Procedure
    Iterable<PersonPhone> sp_PersonPhone_Search(String person_id, String phone_id);

    @Procedure
    void sp_PersonPhone_Undelete(String id);

    @Procedure
    void sp_PersonPhone_Update(String id, String person_id, String phone_id);
}
