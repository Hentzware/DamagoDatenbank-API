package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.PersonKlasse;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonKlasseRepository {
    @Procedure
    String sp_PersonClass_Add(String name, String nr);

    @Procedure
    void sp_PersonClass_Delete(String id);

    @Procedure
    void sp_PersonClass_DeletePermanent(String id);

    @Procedure
    Iterable<PersonKlasse> sp_PersonClass_Get();

    @Procedure
    PersonKlasse sp_PersonClass_GetById(String id);

    @Procedure
    Iterable<PersonKlasse> sp_PersonClass_GetDeleted();

    @Procedure
    Iterable<PersonKlasse> sp_PersonClass_Search(String personId, String klasseId);

    @Procedure
    void sp_PersonClass_Update(String id, String name, String nr);
}
