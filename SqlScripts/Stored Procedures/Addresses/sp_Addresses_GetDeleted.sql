CREATE PROCEDURE sp_Addresses_GetDeleted ()
BEGIN
    SELECT * FROM addresses WHERE is_deleted = true;
END