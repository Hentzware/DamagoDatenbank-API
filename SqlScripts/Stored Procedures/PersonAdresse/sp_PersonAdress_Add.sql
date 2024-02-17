CREATE PROCEDURE sp_PersonAdress_Add (IN in_personId VARCHAR(36), IN in_adresseId VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO PersonAdresse (Id, PersonId, AdresseId, IsDeleted)
    VALUES (out_id, in_personId, in_adresseId, false);
END