CREATE PROCEDURE sp_Classes_GetDeleted ()
BEGIN
    SELECT * FROM Klassen WHERE IsDeleted = true;
END