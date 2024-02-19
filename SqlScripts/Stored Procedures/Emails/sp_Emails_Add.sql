CREATE PROCEDURE sp_Emails_Add (IN in_email varchar(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO emails (id, email, is_deleted)
        VALUES (out_id, in_email, false);
END