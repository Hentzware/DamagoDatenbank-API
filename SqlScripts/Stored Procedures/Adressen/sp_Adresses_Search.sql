CREATE PROCEDURE sp_Adresses_Search (IN in_strasse VARCHAR(100), IN in_hausnummer VARCHAR(100), IN in_postleitzahl VARCHAR(100), IN in_ort VARCHAR(100), IN in_land VARCHAR(100))
BEGIN
    SELECT * FROM Adressen
    WHERE (Strasse LIKE CONCAT('%', in_strasse, '%') OR in_strasse IS NULL)
      AND (Hausnummer LIKE CONCAT('%', in_hausnummer, '%') OR in_hausnummer IS NULL)
      AND (Postleitzahl = in_postleitzahl OR in_postleitzahl IS NULL)
      AND (Ort = in_ort OR in_ort IS NULL)
      AND (Land = in_land OR in_land IS NULL);
END