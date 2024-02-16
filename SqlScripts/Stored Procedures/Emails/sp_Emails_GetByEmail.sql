CREATE PROCEDURE sp_Emails_GetByEmail (in in_email varchar(100))
BEGIN
    SELECT * FROM Emails WHERE Email LIKE CONCAT('%', in_email, '%');
END