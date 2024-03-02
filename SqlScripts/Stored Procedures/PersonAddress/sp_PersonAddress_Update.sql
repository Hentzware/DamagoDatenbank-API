CREATE PROCEDURE sp_PersonAddress_Update (IN in_id VARCHAR(36), IN in_person_id VARCHAR(36), IN in_address_id VARCHAR(36))
BEGIN
    UPDATE person_address
        SET
            person_id = IF (in_person_id IS NOT NULL, in_person_id, person_id),
            address_id = IF (in_address_id IS NOT NULL, in_address_id, address_id)
    WHERE Id = in_id;
end;