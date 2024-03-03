CREATE PROCEDURE sp_Module_Get ()
BEGIN
    SELECT * FROM module WHERE is_deleted = false;
END