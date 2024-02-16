CREATE PROCEDURE sp_Classes_GetDeleted ()
BEGIN
    SELECT * FROM Klasse WHERE IsDeleted = true;
END