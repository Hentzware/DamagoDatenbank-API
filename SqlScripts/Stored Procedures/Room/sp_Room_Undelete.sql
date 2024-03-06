CREATE PROCEDURE sp_Room_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE room SET is_deleted = false WHERE id = in_id;
END