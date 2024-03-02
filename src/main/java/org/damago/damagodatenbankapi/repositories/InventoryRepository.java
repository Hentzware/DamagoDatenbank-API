package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface InventoryRepository extends JpaRepository<Inventory, String> {
    @Procedure
    String sp_Inventory_Add(String name, int amount);

    @Procedure
    void sp_Inventory_Delete(String id);

    @Procedure
    void sp_Inventory_DeletePermanent(String id);

    @Procedure
    Iterable<Inventory> sp_Inventory_Get();

    @Procedure
    Inventory sp_Inventory_GetById(String id);

    @Procedure
    Iterable<Inventory> sp_Inventory_GetDeleted();

    @Procedure
    Iterable<Inventory> sp_Inventory_Search(String name, int amount);

    @Procedure
    void sp_Inventory_Undelete(String id);

    @Procedure
    void sp_Inventory_Update(String id, String name, int amount);
}
