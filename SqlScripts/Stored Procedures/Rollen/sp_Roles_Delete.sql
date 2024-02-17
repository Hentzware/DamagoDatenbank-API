CREATE PROCEDURE sp_Roles_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE Rollen SET IsDeleted = true WHERE Id = in_id;
END