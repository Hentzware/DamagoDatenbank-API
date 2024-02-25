package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AddressRepository extends JpaRepository<Address, String> {
    @Procedure
    String sp_Addresses_Add(String street, String house_number, String postal_code, String location, String country);

    @Procedure
    void sp_Addresses_Delete(String id);

    @Procedure
    void sp_Addresses_DeletePermanent(String id);

    @Procedure
    Iterable<Address> sp_Addresses_Get();

    @Procedure
    Address sp_Addresses_GetById(String id);

    @Procedure
    Iterable<Address> sp_Addresses_GetDeleted();

    @Procedure
    Iterable<Address> sp_Addresses_Search(String street, String house_number, String postal_code, String location, String country);

    @Procedure
    void sp_Addresses_Undelete(String id);

    @Procedure
    void sp_Addresses_Update(String id, String street, String house_number, String postal_code, String location, String country);
}
