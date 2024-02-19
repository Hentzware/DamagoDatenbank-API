CREATE PROCEDURE sp_Emails_Delete (IN in_id varchar(36))
BEGIN
    UPDATE emails SET is_deleted = true WHERE id = in_id;
END