CREATE PROCEDURE sp_Emails_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE emails SET is_deleted = false WHERE id = in_id;
END