CREATE PROCEDURE sp_Emails_Search (IN in_email VARCHAR(100))
BEGIN
    SELECT * FROM emails
    WHERE (email LIKE CONCAT('%', in_email, '%') OR in_email IS NULL);
END