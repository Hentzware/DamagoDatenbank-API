CREATE PROCEDURE sp_Emails_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE Emails SET IsDeleted = false WHERE Id = in_id;
END