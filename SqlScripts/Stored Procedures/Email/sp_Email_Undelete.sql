CREATE PROCEDURE sp_Email_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE email SET is_deleted = false WHERE id = in_id;
END