CREATE PROCEDURE sp_PersonPhone_Get ()
BEGIN
    SELECT * FROM person_phone WHERE is_deleted = false;
END