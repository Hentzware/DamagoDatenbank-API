CREATE PROCEDURE sp_Person_Get ()
BEGIN
    SELECT * FROM person WHERE is_deleted = false;
END