CREATE PROCEDURE sp_Persons_GetDeleted ()
BEGIN
    SELECT * FROM personen WHERE is_deleted = true;
END