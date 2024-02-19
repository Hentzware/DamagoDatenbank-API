CREATE PROCEDURE sp_Rooms_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE raeume SET is_deleted = true WHERE id = in_id;
END