CREATE PROCEDURE sp_Inventories_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE inventories SET is_deleted = false WHERE id = in_id;
END