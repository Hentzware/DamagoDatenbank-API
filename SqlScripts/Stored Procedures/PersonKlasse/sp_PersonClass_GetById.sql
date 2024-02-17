CREATE PROCEDURE sp_PersonClass_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM PersonKlasse WHERE Id = in_id;
end;