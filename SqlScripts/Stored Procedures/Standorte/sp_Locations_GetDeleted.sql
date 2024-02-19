CREATE PROCEDURE sp_Locations_GetDeleted ()
BEGIN
    SELECT * FROM standorte WHERE is_deleted = true;
END