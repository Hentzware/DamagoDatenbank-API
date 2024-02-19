CREATE PROCEDURE sp_PersonEmail_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE person_email SET is_deleted = true WHERE id = in_id;
END