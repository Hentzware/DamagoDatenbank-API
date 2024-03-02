CREATE PROCEDURE sp_PersonAddress_Get ()
BEGIN
    SELECT * FROM person_address WHERE is_deleted = false;
END