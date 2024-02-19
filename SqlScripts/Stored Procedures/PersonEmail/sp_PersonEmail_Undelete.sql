CREATE PROCEDURE sp_PersonEmail_Undelete (IN in_id VARCHAR(36))
BEGIN
    UPDATE person_email SET is_deleted = false WHERE id = in_id;
END