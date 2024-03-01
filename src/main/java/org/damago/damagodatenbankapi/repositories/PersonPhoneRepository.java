package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonPhoneRepository extends JpaRepository<PersonPhone, String> {
    @Procedure
    String sp_PersonsPhones_Add();

    @Procedure
    void sp_PersonsPhones_Delete(String id);

    @Procedure
    void sp_PersonsPhones_DeletePermanent(String id);

    @Procedure
    Iterable<PersonPhone> sp_PersonsPhones_Get();

    @Procedure
    PersonPhone sp_PersonsPhones_GetById(String id);

    @Procedure
    Iterable<PersonPhone> sp_PersonsPhones_GetDeleted();

    @Procedure
    Iterable<PersonPhone> sp_PersonsPhones_Search();

    @Procedure
    void sp_PersonsPhones_Undelete(String id);

    @Procedure
    void sp_PersonsPhones_Update(String id);
}
