 CREATE PROCEDURE sp_Persons_Update (IN in_id varchar(36), IN in_nachname varchar(100), IN in_vorname varchar(100), IN in_geburtsdatum date)
 BEGIN
    UPDATE personen
        SET
            nachname = IF (in_nachname IS NOT NULL, in_nachname, nachname),
            vorname = IF (in_vorname IS NOT NULL, in_vorname, vorname),
            geburtsdatum = IF (in_geburtsdatum IS NOT NULL, in_geburtsdatum, geburtsdatum)
     WHERE id = in_id;
 END