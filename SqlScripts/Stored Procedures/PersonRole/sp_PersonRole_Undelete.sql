CREATE PROCEDURE sp_PersonRole_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE personRole SET is_deleted = false WHERE id = in_id;
END