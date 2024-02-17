package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonAdresse;
import org.damago.damagodatenbankapi.entities.PersonEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonEmailRepository extends JpaRepository<PersonEmail, String> {
    @Procedure
    String sp_PersonEmail_Add(String personId, String emailId);

    @Procedure
    void sp_PersonEmail_Delete(String id);

    @Procedure
    void sp_PersonEmail_DeletePermanent(String id);

    @Procedure
    Iterable<PersonEmail> sp_PersonEmail_Get();

    @Procedure
    PersonEmail sp_PersonEmail_GetById(String id);

    @Procedure
    Iterable<PersonEmail> sp_PersonEmail_GetDeleted();

    @Procedure
    Iterable<PersonEmail> sp_PersonEmail_Search(String personId, String emailId);

    @Procedure
    void sp_PersonEmail_Undelete(String id);

    @Procedure
    PersonEmail sp_PersonEmail_Update(String id, String personId, String email);
}
