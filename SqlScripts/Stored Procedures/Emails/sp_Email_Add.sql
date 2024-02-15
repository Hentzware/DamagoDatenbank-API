CREATE PROCEDURE `sp_Email_Add`(IN neu_email varchar(100))
BEGIN
    INSERT INTO Emails (Id, Email, IsDeleted)
        VALUES (UUID(), neu_email, false);
END