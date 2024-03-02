CREATE PROCEDURE sp_Room_Add (IN in_name VARCHAR(100), IN in_nr VARCHAR(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO room (id, name, nr, is_deleted)
    VALUES (out_id, in_name, in_nr, false);
END