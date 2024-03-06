CREATE PROCEDURE sp_Phone_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE phone SET is_deleted = false WHERE id = in_id;
END