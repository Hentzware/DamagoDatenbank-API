CREATE PROCEDURE sp_Locations_Get ()
BEGIN
    SELECT * FROM locations WHERE is_deleted = false;
END