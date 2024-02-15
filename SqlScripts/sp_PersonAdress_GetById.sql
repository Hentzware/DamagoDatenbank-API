CREATE PROCEDURE sp_PersonAdress_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM PersonAdresse WHERE Id = in_id;
end;