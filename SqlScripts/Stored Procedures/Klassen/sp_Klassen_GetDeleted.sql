CREATE PROCEDURE sp_Klassen_GetDeleted ()
BEGIN
    SELECT * FROM Klasse WHERE IsDeleted = true;
END