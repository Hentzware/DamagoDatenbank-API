CREATE PROCEDURE sp_Role_Get ()
BEGIN
    SELECT * FROM role WHERE is_deleted = false;
END