CREATE PROCEDURE sp_PersonClass_Add (IN in_personId VARCHAR(36), IN in_klasseId VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO PersonKlasse (Id, PersonId, KlasseId, IsDeleted)
    VALUES (out_id, in_personId, in_klasseId, false);
END