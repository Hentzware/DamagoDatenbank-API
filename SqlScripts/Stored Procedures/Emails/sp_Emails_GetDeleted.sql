CREATE PROCEDURE sp_Emails_GetDeleted ()
BEGIN
    SELECT * FROM emails WHERE is_deleted = true;
END