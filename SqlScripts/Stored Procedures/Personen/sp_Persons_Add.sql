CREATE PROCEDURE sp_Persons_Add (IN in_nachname VARCHAR(100), IN in_vorname VARCHAR(100), IN in_geburtsdatum DATE)
BEGIN
    INSERT INTO Personen (Id, Nachname, Vorname, Geburtsdatum, IsDeleted)
    VALUES (UUID(), in_nachname, in_vorname, in_geburtsdatum, false);
END