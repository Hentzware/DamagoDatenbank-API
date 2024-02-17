CREATE PROCEDURE sp_PersonLocation_Search (IN in_personId VARCHAR(36), IN in_StandortId VARCHAR(36))
BEGIN
    SELECT * FROM PersonStandort
        WHERE (PersonId = in_personId OR in_personId IS NULL)
          AND (StandortId = in_StandortId OR in_StandortId IS NULL);
END