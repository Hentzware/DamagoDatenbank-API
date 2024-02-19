CREATE PROCEDURE sp_PersonClass_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM person_klasse WHERE id = in_id;
end;