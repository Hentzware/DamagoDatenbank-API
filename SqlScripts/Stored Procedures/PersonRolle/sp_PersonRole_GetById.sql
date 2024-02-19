CREATE PROCEDURE sp_PersonRole_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM person_rolle WHERE id = in_id;
end;