CREATE PROCEDURE sp_Locations_GetDeleted ()
BEGIN
    SELECT * FROM locations WHERE is_deleted = true;
END