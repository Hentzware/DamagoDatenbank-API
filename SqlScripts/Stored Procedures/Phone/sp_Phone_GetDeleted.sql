CREATE PROCEDURE sp_Phone_GetDeleted ()
BEGIN
    SELECT * FROM phone WHERE is_deleted = true;
END