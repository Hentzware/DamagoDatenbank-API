CREATE PROCEDURE sp_Persons_Add (IN in_nachname VARCHAR(100), IN in_vorname VARCHAR(100), IN in_geburtsdatum DATE, OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO Personen (Id, Nachname, Vorname, Geburtsdatum, IsDeleted)
    VALUES (out_id, in_nachname, in_vorname, in_geburtsdatum, false);
END