CREATE PROCEDURE sp_Module_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM module WHERE id = in_id;
END