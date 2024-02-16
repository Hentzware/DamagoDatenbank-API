CREATE PROCEDURE sp_Emails_Get ()
BEGIN
    SELECT * FROM Emails WHERE IsDeleted = false;
END