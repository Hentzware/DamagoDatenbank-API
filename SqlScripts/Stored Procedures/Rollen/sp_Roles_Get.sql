CREATE PROCEDURE sp_Roles_Get ()
BEGIN
    SELECT * FROM rollen WHERE is_deleted = false;
END