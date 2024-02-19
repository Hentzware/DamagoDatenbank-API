CREATE PROCEDURE sp_LocationPerson_Search (IN in_personId VARCHAR(36), IN in_StandortId VARCHAR(36))
BEGIN
    SELECT * FROM standort_person
        WHERE (person_id = in_personId OR in_personId IS NULL)
          AND (standort_id = in_StandortId OR in_StandortId IS NULL);
END