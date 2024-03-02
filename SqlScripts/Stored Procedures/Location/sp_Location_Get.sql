CREATE PROCEDURE sp_Location_Get ()
BEGIN
    SELECT * FROM location WHERE is_deleted = false;
END