CREATE PROCEDURE sp_PersonRole_Add (IN in_personId VARCHAR(36), IN in_role_id VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_role (id, person_id, role_id, is_deleted)
    VALUES (out_id, in_personId, in_role_id, false);
END