CREATE PROCEDURE sp_Inventories_Get ()
BEGIN
    SELECT * FROM inventories WHERE is_deleted = false;
END