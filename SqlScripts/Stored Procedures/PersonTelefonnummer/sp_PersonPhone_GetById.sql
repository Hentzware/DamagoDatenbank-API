CREATE PROCEDURE sp_PersonPhone_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM PersonTelefonnummer WHERE Id = in_id;
end;