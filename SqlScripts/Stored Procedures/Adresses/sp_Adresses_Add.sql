CREATE PROCEDURE sp_Adresses_Add (IN in_strasse VARCHAR(100), IN in_hausnummer VARCHAR(100), IN in_postleitzahl VARCHAR(100), IN in_ort VARCHAR(100), IN in_land VARCHAR(100))
BEGIN
    INSERT INTO Adressen (Id, Strasse, Hausnummer, Postleitzahl, Ort, Land, IsDeleted)
    VALUES (UUID(), in_strasse, in_hausnummer, in_postleitzahl, in_ort, in_land, false);
end;