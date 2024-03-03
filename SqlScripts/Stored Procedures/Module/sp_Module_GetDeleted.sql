CREATE PROCEDURE sp_Module_GetDeleted ()
BEGIN
    SELECT * FROM module WHERE is_deleted = true;
END