CREATE PROCEDURE sp_Location_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE location SET is_deleted = true WHERE id = in_id;
END