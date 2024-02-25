package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface InventoryRepository extends JpaRepository<Inventory, String> {
    @Procedure
    String sp_Inventories_Add(String name, int amount);

    @Procedure
    void sp_Inventories_Delete(String id);

    @Procedure
    void sp_Inventories_DeletePermanent(String id);

    @Procedure
    Iterable<Inventory> sp_Inventories_Get();

    @Procedure
    Inventory sp_Inventories_GetById(String id);

    @Procedure
    Iterable<Inventory> sp_Inventories_GetDeleted();

    @Procedure
    Iterable<Inventory> sp_Inventories_Search(String name, int amount);

    @Procedure
    void sp_Inventories_Undelete(String id);

    @Procedure
    void sp_Inventories_Update(String id, String name, int amount);
}
