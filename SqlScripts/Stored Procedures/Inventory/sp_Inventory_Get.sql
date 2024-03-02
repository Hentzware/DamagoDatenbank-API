CREATE PROCEDURE sp_Inventory_Get ()
BEGIN
    SELECT * FROM inventory WHERE is_deleted = false;
END