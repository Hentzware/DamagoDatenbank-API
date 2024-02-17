CREATE PROCEDURE sp_Roles_Get ()
BEGIN
    SELECT * FROM Rollen WHERE IsDeleted = false;
END