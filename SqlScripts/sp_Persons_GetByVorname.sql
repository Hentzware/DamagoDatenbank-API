CREATE PROCEDURE sp_Persons_GetByVorname (IN in_vorname VARCHAR(100))
BEGIN
    SELECT * FROM Personen WHERE Vorname = CONCAT('%', in_vorname, '%');
end;