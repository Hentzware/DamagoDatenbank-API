package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Telefonnummer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface TelefonnummerRepository extends JpaRepository<Telefonnummer, String> {
    @Procedure
    String sp_Phones_Add(String telefonnummer);

    @Procedure
    void sp_Phones_Delete(String id);

    @Procedure
    void sp_Phones_DeletePermanent(String id);

    @Procedure
    Iterable<Telefonnummer> sp_Phones_Get();

    @Procedure
    Telefonnummer sp_Phones_GetById(String id);

    @Procedure
    Iterable<Telefonnummer> sp_Phones_GetDeleted();

    @Procedure
    Iterable<Telefonnummer> sp_Phones_Search(String telefonnummer);

    @Procedure
    void sp_Phones_Undelete(String id);

    @Procedure
    void sp_Phones_Update(String id, String telefonnummer);
}
