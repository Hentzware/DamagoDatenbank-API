CREATE PROCEDURE sp_Roles_GetDeleted ()
BEGIN
    SELECT * FROM rollen WHERE is_deleted = true;
END