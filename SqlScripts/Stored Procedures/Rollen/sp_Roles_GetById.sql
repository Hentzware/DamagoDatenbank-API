CREATE PROCEDURE sp_Roles_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM Rollen WHERE Id = in_id;
end;