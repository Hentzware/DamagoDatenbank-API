CREATE PROCEDURE sp_Classes_Get ()
BEGIN
    SELECT * FROM Klassen WHERE IsDeleted = false;
END