CREATE PROCEDURE sp_Classes_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE klassen SET is_deleted = false WHERE id = in_id;
END