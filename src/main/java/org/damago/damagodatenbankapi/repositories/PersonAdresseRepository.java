package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonAdresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonAdresseRepository extends JpaRepository<PersonAdresse, String> {
    @Procedure
    PersonAdresse sp_PersonAdress_Add(String personId, String adresseId);

    @Procedure
    void sp_PersonAdress_Delete(String id);

    @Procedure
    void sp_PersonAdress_DeletePermanent(String id);

    @Procedure
    Iterable<PersonAdresse> sp_PersonAdress_Get();

    @Procedure
    Iterable<PersonAdresse> sp_PersonAdress_GetByAdressId(String adresseId);

    @Procedure
    PersonAdresse sp_PersonAdress_GetById(String id);

    @Procedure
    Iterable<PersonAdresse> sp_PersonAdress_GetByPersonId(String personId);

    @Procedure
    void sp_PersonAdress_Undelete(String id);

    @Procedure
    PersonAdresse sp_PersonAdress_Update(String id, String personId, String adresseId);
}
