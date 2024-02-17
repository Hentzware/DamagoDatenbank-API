package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

public interface EmailRepository extends JpaRepository<Email, String> {
    @Procedure
    @Transactional(readOnly = true)
    Email sp_Emails_Add(String email);

    @Procedure
    @Transactional(readOnly = true)
    void sp_Emails_Delete(String id);

    @Procedure
    @Transactional(readOnly = true)
    void sp_Emails_DeletePermanent(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Email> sp_Emails_Get();

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Email> sp_Emails_GetByEmail(String email);

    @Procedure
    @Transactional(readOnly = true)
    Email sp_Emails_GetById(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Email> sp_Emails_GetDeleted();

    @Procedure
    @Transactional(readOnly = true)
    void sp_Emails_Undelete(String id);

    @Procedure
    @Transactional(readOnly = true)
    Email sp_Emails_Update(String id, String email);
}
