CREATE PROCEDURE sp_Emails_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM emails WHERE id = in_id;
END