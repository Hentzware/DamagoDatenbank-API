CREATE PROCEDURE sp_Persons_GetDeleted ()
BEGIN
    SELECT * FROM persons WHERE is_deleted = true;
END