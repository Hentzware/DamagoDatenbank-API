package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PhoneRepository extends JpaRepository<Phone, String> {
    @Procedure
    String sp_Phones_Add();

    @Procedure
    void sp_Phones_Delete(String id);

    @Procedure
    void sp_Phones_DeletePermanent(String id);

    @Procedure
    Iterable<Phone> sp_Phones_Get();

    @Procedure
    Phone sp_Phones_GetById(String id);

    @Procedure
    Iterable<Phone> sp_Phones_GetDeleted();

    @Procedure
    Iterable<Phone> sp_Phones_Search();

    @Procedure
    void sp_Phones_Undelete(String id);

    @Procedure
    void sp_Phones_Update(String id);
}
