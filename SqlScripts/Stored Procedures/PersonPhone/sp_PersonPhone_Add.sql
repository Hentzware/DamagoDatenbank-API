CREATE PROCEDURE sp_PersonPhone_Add (IN in_personId VARCHAR(36), IN in_phone_id VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_phone (id, person_id, phone_id, is_deleted)
    VALUES (out_id, in_personId, in_phone_id, false);
END