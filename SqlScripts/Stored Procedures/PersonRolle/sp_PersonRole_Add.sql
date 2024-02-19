CREATE PROCEDURE sp_PersonRole_Add (IN in_personId VARCHAR(36), IN in_RolleId VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_rolle (id, person_id, rolle_id, is_deleted)
    VALUES (out_id, in_personId, in_RolleId, false);
END