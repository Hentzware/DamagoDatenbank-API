package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonAddressRepository extends JpaRepository<PersonAddress, String> {
    @Procedure
    String sp_PersonAddress_Add(String person_id, String address_id);

    @Procedure
    void sp_PersonAddress_Delete(String id);

    @Procedure
    void sp_PersonAddress_DeletePermanent(String id);

    @Procedure
    Iterable<PersonAddress> sp_PersonAddress_Get();

    @Procedure
    PersonAddress sp_PersonAddress_GetById(String id);

    @Procedure
    Iterable<PersonAddress> sp_PersonAddress_GetDeleted();

    @Procedure
    Iterable<PersonAddress> sp_PersonAddress_Search(String person_id, String address_id);

    @Procedure
    void sp_PersonAddress_Undelete(String id);

    @Procedure
    void sp_PersonAddress_Update(String id, String person_id, String address_id);
}
