CREATE PROCEDURE sp_Phones_Add (IN in_telefonnummer VARCHAR(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO telefonnummern (id, telefonnummer, is_deleted)
    VALUES (out_id, in_telefonnummer, false);
END