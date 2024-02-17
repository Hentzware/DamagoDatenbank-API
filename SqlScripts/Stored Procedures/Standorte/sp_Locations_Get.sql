CREATE PROCEDURE sp_Locations_Get ()
BEGIN
    SELECT * FROM Standorte WHERE IsDeleted = false;
END