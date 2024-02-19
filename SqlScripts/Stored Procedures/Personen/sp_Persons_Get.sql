CREATE PROCEDURE sp_Persons_Get ()
BEGIN
    SELECT * FROM personen WHERE is_deleted = false;
END