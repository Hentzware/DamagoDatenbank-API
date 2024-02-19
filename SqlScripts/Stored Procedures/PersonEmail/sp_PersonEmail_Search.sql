CREATE PROCEDURE sp_PersonEmail_Search (IN in_personId VARCHAR(36), IN in_emailId VARCHAR(36))
BEGIN
    SELECT * FROM person_email
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (email_id = in_emailId OR in_emailId IS NULL);
END