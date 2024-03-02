CREATE PROCEDURE sp_Address_GetDeleted ()
BEGIN
    SELECT * FROM address WHERE is_deleted = true;
END