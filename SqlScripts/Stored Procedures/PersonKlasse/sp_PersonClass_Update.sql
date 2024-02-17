 CREATE PROCEDURE sp_PersonClass_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_klasseId varchar(36))
 BEGIN
    UPDATE PersonKlasse
        SET
            PersonId = IF (in_personId IS NOT NULL, in_personId, PersonId),
            KlasseId = IF (in_klasseId IS NOT NULL, in_klasseId, KlasseId)
     WHERE Id = in_id;
 END