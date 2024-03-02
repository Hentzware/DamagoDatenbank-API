CREATE PROCEDURE sp_PersonPhone_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM person_phone WHERE id = in_id;
end;