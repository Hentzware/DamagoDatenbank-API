CREATE PROCEDURE sp_PersonEmail_Update (IN in_id VARCHAR(36), IN in_personId VARCHAR(36), IN in_emailId VARCHAR(36))
BEGIN
    UPDATE PersonEmail
        SET
            PersonId = IF (in_personId IS NOT NULL, in_personId, PersonId),
            EmailId = IF (in_emailId IS NOT NULL, in_emailId, EmailId)
    WHERE Id = in_id;
END