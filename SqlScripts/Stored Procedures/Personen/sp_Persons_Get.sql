CREATE PROCEDURE sp_Persons_Get ()
BEGIN
    SELECT * FROM Personen WHERE IsDeleted = false;
END