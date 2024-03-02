CREATE PROCEDURE sp_PersonPhone_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE person_phone SET is_deleted = true WHERE id = in_id;
END