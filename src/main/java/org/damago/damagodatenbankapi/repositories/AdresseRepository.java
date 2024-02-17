package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

public interface AdresseRepository extends JpaRepository<Adresse, String> {
    @Procedure
    @Transactional(readOnly = true)
    Adresse sp_Adresses_Add(String strasse, String hausnummer, String postleitzahl, String ort, String land);

    @Procedure
    @Transactional(readOnly = true)
    void sp_Adresses_Delete(String id);

    @Procedure
    @Transactional(readOnly = true)
    void sp_Adresses_DeletePermanent(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Adresse> sp_Adresses_Get();

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Adresse> sp_Adresses_GetByHausnummer(String hausnummer);

    @Procedure
    @Transactional(readOnly = true)
    Adresse sp_Adresses_GetById(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Adresse> sp_Adresses_GetByLand(String land);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Adresse> sp_Adresses_GetByOrt(String ort);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Adresse> sp_Adresses_GetByPostleitzahl(String postleitzahl);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Adresse> sp_Adresses_GetByStrasse(String strasse);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Adresse> sp_Adresses_GetDeleted();

    @Procedure
    @Transactional(readOnly = true)
    void sp_Adresses_Undelete(String id);

    @Procedure
    @Transactional(readOnly = true)
    Adresse sp_Adresses_Update(String id, String strasse, String hausnummer, String postleitzahl, String ort, String land);
}
