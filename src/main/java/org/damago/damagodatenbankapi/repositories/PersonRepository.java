package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

public interface PersonRepository extends JpaRepository<Person, String> {
    @Procedure
    @Transactional(readOnly = true)
    void sp_Persons_Add(String nachname, String vorname, Date geburtsdatum);

    @Procedure
    @Transactional(readOnly = true)
    Person sp_Persons_Delete(String id);

    @Procedure
    @Transactional(readOnly = true)
    Person sp_Persons_DeletePermanent(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Person> sp_Persons_Get();

    @Procedure
    @Transactional(readOnly = true)
    Collection<? extends Person> sp_Persons_GetByGeburtsdatum(Date date);

    @Procedure
    @Transactional(readOnly = true)
    Person sp_Persons_GetById(String id);

    @Procedure
    @Transactional(readOnly = true)
    Collection<? extends Person> sp_Persons_GetByNachname(String nachname);

    @Procedure
    @Transactional(readOnly = true)
    Collection<? extends Person> sp_Persons_GetByVorname(String vorname);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Person> sp_Persons_GetDeleted();

    @Procedure
    @Transactional(readOnly = true)
    void sp_Persons_Update(String id, String nachname, String vorname, Date geburtsdatum);
}
