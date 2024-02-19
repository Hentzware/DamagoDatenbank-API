CREATE PROCEDURE sp_PersonPhone_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM person_telefonnummer WHERE id = in_id;
end;