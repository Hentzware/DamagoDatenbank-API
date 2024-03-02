CREATE PROCEDURE sp_Email_Add (IN in_email varchar(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO email (id, email, is_deleted)
        VALUES (out_id, in_email, false);
END