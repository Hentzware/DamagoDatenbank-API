package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional(readOnly = true)
public interface PersonRepository extends JpaRepository<Person, String> {
    @Procedure
    String sp_Persons_Add(String last_name, String first_name, Date birthdate);

    @Procedure
    void sp_Persons_Delete(String id);

    @Procedure
    void sp_Persons_DeletePermanent(String id);

    @Procedure
    Iterable<Person> sp_Persons_Get();

    @Procedure
    Person sp_Persons_GetById(String id);

    @Procedure
    Iterable<Person> sp_Persons_GetDeleted();

    @Procedure
    Iterable<Person> sp_Persons_Search(String last_name, String first_name, Date birthdate);

    @Procedure
    void sp_Persons_Update(String id, String last_name, String first_name, Date birthdate);
}
