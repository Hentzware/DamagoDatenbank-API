package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonAddressRepository extends JpaRepository<PersonAddress, String> {
    @Procedure
    String sp_PersonsAddresses_Add();

    @Procedure
    void sp_PersonsAddresses_Delete(String id);

    @Procedure
    void sp_PersonsAddresses_DeletePermanent(String id);

    @Procedure
    Iterable<PersonAddress> sp_PersonsAddresses_Get();

    @Procedure
    PersonAddress sp_PersonsAddresses_GetById(String id);

    @Procedure
    Iterable<PersonAddress> sp_PersonsAddresses_GetDeleted();

    @Procedure
    Iterable<PersonAddress> sp_PersonsAddresses_Search();

    @Procedure
    void sp_PersonsAddresses_Undelete(String id);

    @Procedure
    void sp_PersonsAddresses_Update(String id);
}
