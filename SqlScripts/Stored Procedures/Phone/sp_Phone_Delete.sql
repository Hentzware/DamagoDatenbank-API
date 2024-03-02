CREATE PROCEDURE sp_Phone_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE phone SET is_deleted = true WHERE id = in_id;
END