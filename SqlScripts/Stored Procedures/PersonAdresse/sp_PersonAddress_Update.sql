CREATE PROCEDURE sp_PersonAddress_Update (IN in_id VARCHAR(36), IN in_personId VARCHAR(36), IN in_adressId VARCHAR(36))
BEGIN
    UPDATE person_address
        SET
            person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
            address_id = IF (in_adressId IS NOT NULL, in_adressId, address_id)
    WHERE Id = in_id;
end;