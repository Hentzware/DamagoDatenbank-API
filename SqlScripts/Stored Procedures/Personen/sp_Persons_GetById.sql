CREATE PROCEDURE sp_Persons_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM personen WHERE id = in_id;
end;