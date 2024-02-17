CREATE PROCEDURE sp_PersonEmail_Search (IN in_personId VARCHAR(100), IN in_emailId VARCHAR(100))
BEGIN
    SELECT * FROM PersonEmail
    WHERE (PersonId = in_personId OR in_personId IS NULL)
      AND (EmailId = in_emailId OR in_emailId IS NULL);
END