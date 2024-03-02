CREATE PROCEDURE sp_PersonPhone_GetDeleted ()
BEGIN
    SELECT * FROM person_phone WHERE is_deleted = true;
END