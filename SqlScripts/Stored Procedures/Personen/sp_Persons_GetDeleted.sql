CREATE PROCEDURE sp_Persons_GetDeleted ()
BEGIN
    SELECT * FROM Personen WHERE IsDeleted = true;
END