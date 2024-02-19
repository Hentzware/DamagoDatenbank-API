CREATE PROCEDURE sp_Rooms_Get ()
BEGIN
    SELECT * FROM raeume WHERE is_deleted = false;
END