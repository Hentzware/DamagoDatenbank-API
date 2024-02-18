package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AdresseRepository extends JpaRepository<Adresse, String> {
    @Procedure
    String sp_Adresses_Add(String strasse, String hausnummer, String postleitzahl, String ort, String land);

    @Procedure
    void sp_Adresses_Delete(String id);

    @Procedure
    void sp_Adresses_DeletePermanent(String id);

    @Procedure
    Iterable<Adresse> sp_Adresses_Get();

    @Procedure
    Adresse sp_Adresses_GetById(String id);

    @Procedure
    Iterable<Adresse> sp_Adresses_GetDeleted();

    @Procedure
    Iterable<Adresse> sp_Adresses_Search(String strasse, String hausnummer, String postleitzahl, String ort, String land);

    @Procedure
    void sp_Adresses_Undelete(String id);

    @Procedure
    void sp_Adresses_Update(String id, String strasse, String hausnummer, String postleitzahl, String ort, String land);
}
