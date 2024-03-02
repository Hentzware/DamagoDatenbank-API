CREATE PROCEDURE sp_Role_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM role WHERE id = in_id;
end;