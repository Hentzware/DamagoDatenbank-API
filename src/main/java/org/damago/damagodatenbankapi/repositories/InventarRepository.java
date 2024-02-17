package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Inventar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

public interface InventarRepository extends JpaRepository<Inventar, String> {
    @Procedure
    @Transactional(readOnly = true)
    Inventar sp_Inventory_Add(String name, int anzahl);

    @Procedure
    @Transactional(readOnly = true)
    void sp_Inventory_Delete(String id);

    @Procedure
    @Transactional(readOnly = true)
    void sp_Inventory_DeletePermanent(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Inventar> sp_Inventory_Get();

    @Procedure
    @Transactional(readOnly = true)
    Inventar sp_Inventory_GetById(String id);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Inventar> sp_Inventory_GetByName(String name);

    @Procedure
    @Transactional(readOnly = true)
    Iterable<Inventar> sp_Inventory_GetDeleted();

    @Procedure
    @Transactional(readOnly = true)
    void sp_Inventory_Undelete(String id);

    @Procedure
    @Transactional(readOnly = true)
    Inventar sp_Inventory_Update(String id, String name, int anzahl);
}
