CREATE PROCEDURE sp_Room_Get ()
BEGIN
    SELECT * FROM room WHERE is_deleted = false;
END