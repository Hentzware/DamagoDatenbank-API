CREATE PROCEDURE sp_Role_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE role SET is_deleted = false WHERE id = in_id;
END