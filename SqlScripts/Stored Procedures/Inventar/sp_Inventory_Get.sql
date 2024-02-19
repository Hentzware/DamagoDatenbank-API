CREATE PROCEDURE sp_Inventory_Get ()
BEGIN
    SELECT * FROM inventar WHERE is_deleted = false;
END