CREATE PROCEDURE sp_PersonPhone_Search (IN in_personId VARCHAR(36), IN in_telefonnummerId VARCHAR(36))
BEGIN
    SELECT * FROM PersonTelefonnummer
        WHERE (PersonId = in_personId OR in_personId IS NULL)
          AND (TelefonnummerId = in_telefonnummerId OR in_telefonnummerId IS NULL);
END