CREATE PROCEDURE sp_Inventories_GetDeleted()
BEGIN
    SELECT * FROM inventories WHERE is_deleted = true;
END