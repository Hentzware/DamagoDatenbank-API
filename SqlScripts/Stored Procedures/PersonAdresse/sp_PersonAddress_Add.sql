CREATE PROCEDURE sp_PersonAddress_Add (IN in_personId VARCHAR(36), IN in_adresseId VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_address (id, person_id, address_id, is_deleted)
    VALUES (out_id, in_personId, in_adresseId, false);
END