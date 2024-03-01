CREATE PROCEDURE sp_PersonAddress_Search (IN in_personId VARCHAR(36), IN in_adressId VARCHAR(36))
BEGIN
    SELECT * FROM person_address
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (address_id = in_adressId OR in_adressId IS NULL);
END