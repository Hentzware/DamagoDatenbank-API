package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PhoneRepository extends JpaRepository<Phone, String> {
    @Procedure
    String sp_Phone_Add(String phone);

    @Procedure
    void sp_Phone_Delete(String id);

    @Procedure
    void sp_Phone_DeletePermanent(String id);

    @Procedure
    Iterable<Phone> sp_Phone_Get();

    @Procedure
    Phone sp_Phone_GetById(String id);

    @Procedure
    Iterable<Phone> sp_Phone_GetDeleted();

    @Procedure
    Iterable<Phone> sp_Phone_Search(String phone);

    @Procedure
    void sp_Phone_Undelete(String id);

    @Procedure
    void sp_Phone_Update(String id, String phone);
}
