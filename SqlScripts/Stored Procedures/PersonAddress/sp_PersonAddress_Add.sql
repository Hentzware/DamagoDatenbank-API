CREATE PROCEDURE sp_PersonAddress_Add (IN in_person_id VARCHAR(36), IN in_address_id VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_address (id, person_id, address_id, is_deleted)
    VALUES (out_id, in_person_id, in_address_id, false);
END