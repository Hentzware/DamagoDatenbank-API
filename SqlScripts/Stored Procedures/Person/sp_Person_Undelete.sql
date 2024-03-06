CREATE PROCEDURE sp_Person_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE person SET is_deleted = false WHERE id = in_id;
END