CREATE PROCEDURE sp_Emails_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM Emails WHERE Id = in_id;
END