CREATE PROCEDURE sp_Roles_Add (IN in_name VARCHAR(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO rollen (id, name, is_deleted)
    VALUES (out_id, in_name, false);
END