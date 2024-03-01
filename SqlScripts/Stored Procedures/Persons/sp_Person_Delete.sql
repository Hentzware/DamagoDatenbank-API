CREATE PROCEDURE sp_Person_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE person SET is_deleted = true WHERE id = in_id;
END