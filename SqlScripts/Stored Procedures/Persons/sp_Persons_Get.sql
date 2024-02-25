CREATE PROCEDURE sp_Persons_Get ()
BEGIN
    SELECT * FROM persons WHERE is_deleted = false;
END