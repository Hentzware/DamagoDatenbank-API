CREATE PROCEDURE sp_Locations_GetDeleted ()
BEGIN
    SELECT * FROM Standorte WHERE IsDeleted = true;
END