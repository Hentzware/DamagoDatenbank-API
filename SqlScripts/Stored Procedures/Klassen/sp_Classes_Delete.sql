CREATE PROCEDURE sp_Classes_Delete (IN in_id varchar(36))
BEGIN
    UPDATE klassen SET is_deleted = true WHERE id = in_id;
END