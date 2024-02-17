CREATE PROCEDURE sp_PersonAdress_Search (IN in_personId VARCHAR(36), IN in_adressId VARCHAR(36))
BEGIN
    SELECT * FROM PersonAdresse
    WHERE (PersonId = in_personId OR in_personId IS NULL)
      AND (AdresseId = in_adressId OR in_adressId IS NULL);
END