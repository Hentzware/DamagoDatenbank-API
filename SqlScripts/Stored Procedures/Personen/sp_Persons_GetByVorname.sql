CREATE PROCEDURE sp_Persons_GetByVorname (IN in_vorname VARCHAR(100))
BEGIN
    SELECT * FROM Personen WHERE Vorname LIKE CONCAT('%', in_vorname, '%') AND IsDeleted = false;
end;