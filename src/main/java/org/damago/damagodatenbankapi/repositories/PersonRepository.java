package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}
