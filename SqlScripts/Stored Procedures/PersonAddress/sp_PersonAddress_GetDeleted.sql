CREATE PROCEDURE sp_PersonAddress_GetDeleted ()
BEGIN
    SELECT * FROM personAddress WHERE is_deleted = true;
END