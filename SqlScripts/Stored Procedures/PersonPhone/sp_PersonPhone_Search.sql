CREATE PROCEDURE sp_PersonPhone_Search (IN in_personId VARCHAR(36), IN in_phone_id VARCHAR(36))
BEGIN
    SELECT * FROM person_phone
        WHERE (person_id = in_personId OR in_personId IS NULL)
          AND (phone_id = in_phone_id OR in_phone_id IS NULL);
END