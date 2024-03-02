CREATE PROCEDURE sp_Email_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM email WHERE id = in_id;
END