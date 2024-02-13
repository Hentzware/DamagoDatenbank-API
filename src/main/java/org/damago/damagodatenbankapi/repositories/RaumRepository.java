package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Raum;
import org.springframework.data.repository.CrudRepository;

public interface RaumRepository extends CrudRepository<Raum, String> {
}
