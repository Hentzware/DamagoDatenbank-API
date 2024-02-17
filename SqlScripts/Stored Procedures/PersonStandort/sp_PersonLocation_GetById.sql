CREATE PROCEDURE sp_PersonLocation_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM PersonStandort WHERE Id = in_id;
end;