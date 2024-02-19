CREATE PROCEDURE sp_PersonPhone_Search (IN in_personId VARCHAR(36), IN in_telefonnummerId VARCHAR(36))
BEGIN
    SELECT * FROM person_telefonnummer
        WHERE (person_id = in_personId OR in_personId IS NULL)
          AND (telefonnummer_id = in_telefonnummerId OR in_telefonnummerId IS NULL);
END