CREATE PROCEDURE sp_PersonPhone_Get ()
BEGIN
    SELECT * FROM person_telefonnummer WHERE is_deleted = false;
END