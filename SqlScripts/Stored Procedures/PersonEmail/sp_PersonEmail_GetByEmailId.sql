CREATE PROCEDURE sp_PersonEmail_GetByEmailId (IN in_emailId VARCHAR(36))
BEGIN
    SELECT * FROM PersonEmail WHERE EmailId = in_emailId AND IsDeleted = false;
END