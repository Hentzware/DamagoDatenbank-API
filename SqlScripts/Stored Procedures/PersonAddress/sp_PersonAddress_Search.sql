CREATE PROCEDURE sp_PersonAddress_Search (IN in_person_id VARCHAR(36), IN in_address_id VARCHAR(36))
BEGIN
    SELECT * FROM person_address
    WHERE (person_id = in_person_id OR in_person_id IS NULL)
      AND (address_id = in_address_id OR in_address_id IS NULL);
END