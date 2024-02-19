CREATE PROCEDURE sp_Emails_Get ()
BEGIN
    SELECT * FROM emails WHERE is_deleted = false;
END