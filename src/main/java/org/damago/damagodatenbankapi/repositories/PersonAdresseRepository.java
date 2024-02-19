package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonAdresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonAdresseRepository extends JpaRepository<PersonAdresse, String> {
    @Procedure
    String sp_PersonAdress_Add(String person_id, String adresse_id);

    @Procedure
    void sp_PersonAdress_Delete(String id);

    @Procedure
    void sp_PersonAdress_DeletePermanent(String id);

    @Procedure
    Iterable<PersonAdresse> sp_PersonAdress_Get();

    @Procedure
    PersonAdresse sp_PersonAdress_GetById(String id);

    @Procedure
    Iterable<PersonAdresse> sp_PersonAdress_GetDeleted();

    @Procedure
    Iterable<PersonAdresse> sp_PersonAdress_Search(String person_id, String adresse_id);

    @Procedure
    void sp_PersonAdress_Undelete(String id);

    @Procedure
    void sp_PersonAdress_Update(String id, String person_id, String adresse_id);
}
