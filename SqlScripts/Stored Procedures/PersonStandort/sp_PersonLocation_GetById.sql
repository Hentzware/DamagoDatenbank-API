CREATE PROCEDURE sp_PersonLocation_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM person_standort WHERE id = in_id;
end;