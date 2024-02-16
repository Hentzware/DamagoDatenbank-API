CREATE PROCEDURE sp_PersonEmail_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM PersonEmail WHERE Id = in_id;
END