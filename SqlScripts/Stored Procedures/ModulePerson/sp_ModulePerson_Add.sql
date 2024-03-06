CREATE PROCEDURE sp_ModulePerson_Add (IN in_placeholder varchar(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO modulePerson (id, placeholder, is_deleted)
        VALUES (out_id, in_placeholder, false);
END