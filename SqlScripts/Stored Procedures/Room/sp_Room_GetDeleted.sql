CREATE PROCEDURE sp_Room_GetDeleted ()
BEGIN
    SELECT * FROM room WHERE is_deleted = true;
END