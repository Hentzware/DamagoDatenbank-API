package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Transactional(readOnly = true)
public interface PersonRepository extends JpaRepository<Person, String> {
    @Procedure
    String sp_Persons_Add(String nachname, String vorname, Date geburtsdatum);

    @Procedure
    void sp_Persons_Delete(String id);

    @Procedure
    void sp_Persons_DeletePermanent(String id);

    @Procedure
    Iterable<Person> sp_Persons_Get();

    @Procedure
    Optional<Person> sp_Persons_GetById(String id);

    @Procedure
    Iterable<Person> sp_Persons_GetDeleted();

    @Procedure
    Iterable<Person> sp_Persons_Search(String nachname, String vorname, Date geburtsdatum);

    @Procedure
    void sp_Persons_Update(String id, String nachname, String vorname, Date geburtsdatum);
}
