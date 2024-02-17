package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonAdresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

public interface PersonAdresseRepository extends JpaRepository<PersonAdresse, String> {
    @Procedure
    @Transactional(readOnly = true)
    PersonAdresse sp_PersonAdress_Add(String personId, String adresseId);

    @Procedure
    @Transactional(readOnly = true)
    void sp_PersonAdress_Delete(String id);

    @Procedure
    @Transactional(readOnly = true)
    void sp_PersonAdress_DeletePermanent(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<PersonAdresse> sp_PersonAdress_Get();

    @Procedure
    @Transactional(readOnly = true)
    Iterable<PersonAdresse> sp_PersonAdress_GetByAdressId(String adresseId);

    @Procedure
    @Transactional(readOnly = true)
    PersonAdresse sp_PersonAdress_GetById(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<PersonAdresse> sp_PersonAdress_GetByPersonId(String personId);

    @Procedure
    @Transactional(readOnly = true)
    void sp_PersonAdress_Undelete(String id);

    @Procedure
    @Transactional(readOnly = true)
    PersonAdresse sp_PersonAdress_Update(String id, String personId, String adresseId);
}
