CREATE PROCEDURE sp_Persons_GetByGeburtsdatum (IN in_geburtsdatum DATE)
BEGIN
    SELECT * FROM Personen WHERE Geburtsdatum = in_geburtsdatum AND IsDeleted = false;
end;