CREATE PROCEDURE sp_Inventory_GetDeleted()
BEGIN
    SELECT * FROM inventar WHERE is_deleted = true;
END