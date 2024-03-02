CREATE PROCEDURE sp_Phone_Add (IN in_phone VARCHAR(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO phone (id, phone, is_deleted)
    VALUES (out_id, in_phone, false);
END