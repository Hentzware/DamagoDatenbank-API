 CREATE PROCEDURE sp_Persons_Update (IN in_id varchar(36), IN in_nachname varchar(100), IN in_vorname varchar(100), IN in_geburtsdatum date)
 BEGIN
    UPDATE Personen
        SET
            Nachname = IF (in_nachname IS NOT NULL, in_nachname, Nachname),
            Vorname = IF (in_vorname IS NOT NULL, in_vorname, Vorname),
            Geburtsdatum = IF (in_geburtsdatum IS NOT NULL, in_geburtsdatum, Geburtsdatum)
     WHERE Id = in_id;
 END