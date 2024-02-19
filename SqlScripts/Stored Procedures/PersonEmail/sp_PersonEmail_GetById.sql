CREATE PROCEDURE sp_PersonEmail_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM person_email WHERE id = in_id;
END