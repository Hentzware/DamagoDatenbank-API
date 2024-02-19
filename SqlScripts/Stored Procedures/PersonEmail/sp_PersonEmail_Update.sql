CREATE PROCEDURE sp_PersonEmail_Update (IN in_id VARCHAR(36), IN in_personId VARCHAR(36), IN in_emailId VARCHAR(36))
BEGIN
    UPDATE person_email
        SET
            person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
            email_id = IF (in_emailId IS NOT NULL, in_emailId, email_id)
    WHERE id = in_id;
END