CREATE PROCEDURE sp_Location_GetDeleted ()
BEGIN
    SELECT * FROM location WHERE is_deleted = true;
END