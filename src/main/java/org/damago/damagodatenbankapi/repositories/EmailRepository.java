package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface EmailRepository extends JpaRepository<Email, String> {
    @Procedure
    String sp_Email_Add(String email);

    @Procedure
    void sp_Email_Delete(String id);

    @Procedure
    void sp_Email_DeletePermanent(String id);

    @Procedure
    Iterable<Email> sp_Email_Get();

    @Procedure
    Email sp_Email_GetById(String id);

    @Procedure
    Iterable<Email> sp_Email_GetDeleted();

    @Procedure
    Iterable<Email> sp_Email_Search(String email);

    @Procedure
    void sp_Email_Undelete(String id);

    @Procedure
    void sp_Email_Update(String id, String email);
}
