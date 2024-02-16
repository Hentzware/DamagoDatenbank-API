CREATE PROCEDURE sp_PersonAdresse_Add (IN in_personId VARCHAR(36), IN in_adresseId VARCHAR(36))
BEGIN
    INSERT INTO PersonAdresse (Id, PersonId, AdresseId, IsDeleted)
    VALUES (UUID(), in_personId, in_adresseId, false);
END