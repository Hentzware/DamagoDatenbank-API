CREATE PROCEDURE sp_PersonPhone_GetDeleted ()
BEGIN
    SELECT * FROM person_telefonnummer WHERE is_deleted = true;
END