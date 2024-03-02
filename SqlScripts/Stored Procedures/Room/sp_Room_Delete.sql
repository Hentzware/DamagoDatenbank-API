CREATE PROCEDURE sp_Room_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE room SET is_deleted = true WHERE id = in_id;
END