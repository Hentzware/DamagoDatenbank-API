CREATE PROCEDURE sp_Person_GetDeleted ()
BEGIN
    SELECT * FROM person WHERE is_deleted = true;
END