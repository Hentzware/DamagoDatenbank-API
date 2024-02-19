CREATE PROCEDURE sp_Locations_Get ()
BEGIN
    SELECT * FROM standorte WHERE is_deleted = false;
END