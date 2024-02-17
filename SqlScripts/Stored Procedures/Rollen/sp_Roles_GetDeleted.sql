CREATE PROCEDURE sp_Roles_GetDeleted ()
BEGIN
    SELECT * FROM Rollen WHERE IsDeleted = true;
END