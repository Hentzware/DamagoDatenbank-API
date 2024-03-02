CREATE PROCEDURE sp_PersonAddress_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM person_address WHERE id = in_id;
end;