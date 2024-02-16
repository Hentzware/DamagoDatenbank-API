CREATE PROCEDURE sp_Klassen_Get ()
BEGIN
    SELECT * FROM Klasse WHERE IsDeleted = false;
END