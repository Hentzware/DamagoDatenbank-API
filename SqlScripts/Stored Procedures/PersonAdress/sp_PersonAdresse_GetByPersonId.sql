CREATE PROCEDURE sp_PersonAdresse_GetByPersonId (IN in_personId VARCHAR(36))
BEGIN
    SELECT * FROM PersonAdresse WHERE PersonId = in_personId;
end;