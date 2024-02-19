CREATE PROCEDURE sp_Roles_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM rollen WHERE id = in_id;
end;