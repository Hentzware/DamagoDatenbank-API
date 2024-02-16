CREATE PROCEDURE sp_Persons_Add (IN in_nachname VARCHAR(100), IN in_vorname VARCHAR(100), IN in_geburtsdatum DATE, OUT out_id VARCHAR(36))
BEGIN
    DECLARE in_id VARCHAR(36);
    SET in_id = UUID();
    INSERT INTO Personen (Id, Nachname, Vorname, Geburtsdatum, IsDeleted)
    VALUES (in_id, in_nachname, in_vorname, in_geburtsdatum, false);
    SET out_id = in_id;
END