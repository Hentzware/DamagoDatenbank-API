CREATE PROCEDURE sp_Classes_Get ()
BEGIN
    SELECT * FROM Klasse WHERE IsDeleted = false;
END