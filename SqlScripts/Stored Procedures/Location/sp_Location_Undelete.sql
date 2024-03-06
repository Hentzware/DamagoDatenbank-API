CREATE PROCEDURE sp_Location_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE location SET is_deleted = false WHERE id = in_id;
END