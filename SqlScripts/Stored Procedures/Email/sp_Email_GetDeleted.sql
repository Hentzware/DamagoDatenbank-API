CREATE PROCEDURE sp_Email_GetDeleted ()
BEGIN
    SELECT * FROM email WHERE is_deleted = true;
END