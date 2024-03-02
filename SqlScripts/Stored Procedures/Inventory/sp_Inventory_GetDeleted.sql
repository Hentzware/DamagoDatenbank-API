CREATE PROCEDURE sp_Inventory_GetDeleted()
BEGIN
    SELECT * FROM inventory WHERE is_deleted = true;
END