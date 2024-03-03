CREATE PROCEDURE sp_Module_Add (IN in_name VARCHAR(100), IN in_description VARCHAR(250), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO module (id, name, description, is_deleted)
       VALUES (out_id, in_name, in_description, false);
END