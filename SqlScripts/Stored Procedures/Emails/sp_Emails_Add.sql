CREATE PROCEDURE sp_Emails_Add (IN in_email varchar(100))
BEGIN
    INSERT INTO Emails (Id, Email, IsDeleted)
        VALUES (UUID(), in_email, false);
END