CREATE PROCEDURE sp_Persons_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM Personen WHERE Id = in_id;
end;