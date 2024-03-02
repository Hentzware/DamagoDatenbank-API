CREATE PROCEDURE sp_Email_Update (IN in_id varchar(36), IN in_email varchar(100))
BEGIN
    UPDATE email
        SET
            email = IF (in_email IS NOT NULL, in_email, email)
    WHERE id = in_id;
END