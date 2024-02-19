CREATE PROCEDURE sp_PersonClass_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE person_klasse SET is_deleted = true WHERE id = in_id;
END