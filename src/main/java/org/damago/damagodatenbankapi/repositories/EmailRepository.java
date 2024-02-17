package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface EmailRepository extends JpaRepository<Email, String> {
    @Procedure
    String sp_Emails_Add(String email);

    @Procedure
    void sp_Emails_Delete(String id);

    @Procedure
    void sp_Emails_DeletePermanent(String id);

    @Procedure
    Iterable<Email> sp_Emails_Get();

    @Procedure
    Email sp_Emails_GetById(String id);

    @Procedure
    Iterable<Email> sp_Emails_GetDeleted();

    @Procedure
    Iterable<Email> sp_Emails_Search(String email);

    @Procedure
    void sp_Emails_Undelete(String id);

    @Procedure
    Email sp_Emails_Update(String id, String email);
}
