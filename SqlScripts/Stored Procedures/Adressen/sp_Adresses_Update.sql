CREATE PROCEDURE sp_Adresses_Update (IN in_id VARCHAR(36), IN in_strasse VARCHAR(100), IN in_hausnummer VARCHAR(100), IN in_postleitzahl VARCHAR(100), IN in_ort VARCHAR(100), IN in_land VARCHAR(100))
BEGIN
    UPDATE Adressen
        SET
            Strasse = IF (in_strasse IS NOT NULL, in_strasse, Strasse),
            Hausnummer = IF (in_hausnummer IS NOT NULL, in_hausnummer, Hausnummer),
            Postleitzahl = IF (in_postleitzahl IS NOT NULL, in_postleitzahl, Postleitzahl),
            Ort = IF (in_ort IS NOT NULL, in_ort, Ort),
            Land = IF (in_land IS NOT NULL, in_land, Land);
END