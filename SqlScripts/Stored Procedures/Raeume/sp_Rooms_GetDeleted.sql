CREATE PROCEDURE sp_Rooms_GetDeleted ()
BEGIN
    SELECT * FROM raeume WHERE is_deleted = true;
END