CREATE PROCEDURE sp_Email_Get ()
BEGIN
    SELECT * FROM email WHERE is_deleted = false;
END