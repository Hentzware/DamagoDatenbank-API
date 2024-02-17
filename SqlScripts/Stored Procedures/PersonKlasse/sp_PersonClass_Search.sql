CREATE PROCEDURE sp_PersonClass_Search (IN in_personId VARCHAR(36), IN in_klasseId VARCHAR(36))
BEGIN
    SELECT * FROM PersonKlasse
        WHERE (PersonId = in_personId OR in_personId IS NULL)
          AND (KlasseId = in_klasseId OR in_klasseId IS NULL);
END