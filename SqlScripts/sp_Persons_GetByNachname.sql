CREATE PROCEDURE sp_Persons_GetByNachname (IN in_nachname VARCHAR(100))
BEGIN
    SELECT * FROM Personen WHERE Nachname = CONCAT('%', in_nachname, '%');
end;