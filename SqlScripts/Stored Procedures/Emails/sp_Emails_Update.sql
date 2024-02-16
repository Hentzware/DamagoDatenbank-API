CREATE PROCEDURE sp_Emails_Update (IN in_id varchar(36), IN in_email varchar(100))
BEGIN
    UPDATE Emails
        SET
            Email = IF (in_email IS NOT NULL, in_email, Email)
    WHERE Id = in_id;
END