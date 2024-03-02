CREATE PROCEDURE sp_Email_Delete (IN in_id varchar(36))
BEGIN
    UPDATE email SET is_deleted = true WHERE id = in_id;
END