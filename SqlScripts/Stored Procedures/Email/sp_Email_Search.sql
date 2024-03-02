CREATE PROCEDURE sp_Email_Search (IN in_email VARCHAR(100))
BEGIN
    SELECT * FROM email
    WHERE (email LIKE CONCAT('%', in_email, '%') OR in_email IS NULL);
END