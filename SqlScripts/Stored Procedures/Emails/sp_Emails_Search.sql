CREATE PROCEDURE sp_Emails_Search (IN in_email VARCHAR(100))
BEGIN
    SELECT * FROM Personen
    WHERE (Nachname LIKE CONCAT('%', in_email, '%') OR in_email IS NULL);
END