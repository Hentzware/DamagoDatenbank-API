CREATE PROCEDURE sp_Adresses_Update (IN in_id VARCHAR(36), IN in_strasse VARCHAR(100), IN in_hausnummer VARCHAR(100), IN in_postleitzahl VARCHAR(100), IN in_ort VARCHAR(100), IN in_land VARCHAR(100))
BEGIN
    UPDATE adressen
        SET
            strasse = IF (in_strasse IS NOT NULL, in_strasse, strasse),
            hausnummer = IF (in_hausnummer IS NOT NULL, in_hausnummer, hausnummer),
            postleitzahl = IF (in_postleitzahl IS NOT NULL, in_postleitzahl, postleitzahl),
            ort = IF (in_ort IS NOT NULL, in_ort, ort),
            land = IF (in_land IS NOT NULL, in_land, land)
    WHERE id = in_id;
END