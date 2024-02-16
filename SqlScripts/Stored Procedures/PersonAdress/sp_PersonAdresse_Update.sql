CREATE PROCEDURE sp_PersonAdresse_Update (IN in_id VARCHAR(36), IN in_personId VARCHAR(36), IN in_adressId VARCHAR(36))
BEGIN
    UPDATE PersonAdresse
        SET
            PersonId = IF (in_personId IS NOT NULL, in_personId, PersonId),
            AdresseId = IF (in_adressId IS NOT NULL, in_adressId, AdresseId)
    WHERE Id = in_id;
end;