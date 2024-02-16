CREATE PROCEDURE sp_PersonAdresse_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM PersonAdresse WHERE Id = in_id;
end;