CREATE PROCEDURE sp_Emails_Add (IN in_email varchar(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO Emails (Id, Email, IsDeleted)
        VALUES (out_id, in_email, false);
END