CREATE PROCEDURE sp_Persons_Search (IN in_nachname VARCHAR(100), IN in_vorname VARCHAR(100), IN in_geburtsdatum DATE)
BEGIN
    SELECT * FROM personen
        WHERE (nachname LIKE CONCAT('%', in_nachname, '%') OR in_nachname IS NULL)
          AND (vorname LIKE CONCAT('%', in_vorname, '%') OR in_vorname IS NULL)
          AND (geburtsdatum = in_geburtsdatum OR in_geburtsdatum IS NULL);
END