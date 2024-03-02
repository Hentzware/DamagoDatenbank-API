CREATE PROCEDURE sp_Role_GetDeleted ()
BEGIN
    SELECT * FROM role WHERE is_deleted = true;
END