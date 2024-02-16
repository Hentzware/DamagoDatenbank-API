CREATE PROCEDURE sp_Emails_GetDeleted ()
BEGIN
    SELECT * FROM Emails WHERE IsDeleted = true;
END