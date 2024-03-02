package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AddressRepository extends JpaRepository<Address, String> {
    @Procedure
    String sp_Address_Add(String street, String houseNumber, String postalCode, String location, String country);

    @Procedure
    void sp_Address_Delete(String id);

    @Procedure
    void sp_Address_DeletePermanent(String id);

    @Procedure
    Iterable<Address> sp_Address_Get();

    @Procedure
    Address sp_Address_GetById(String id);

    @Procedure
    Iterable<Address> sp_Address_GetDeleted();

    @Procedure
    Iterable<Address> sp_Address_Search(String street, String houseNumber, String postalCode, String location, String country);

    @Procedure
    void sp_Address_Undelete(String id);

    @Procedure
    void sp_Address_Update(String id, String street, String houseNumber, String postalCode, String location, String country);
}
