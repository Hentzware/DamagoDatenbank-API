package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Inventar;
import org.springframework.data.repository.CrudRepository;

public interface InventarRepository extends CrudRepository<Inventar, String> {
}
