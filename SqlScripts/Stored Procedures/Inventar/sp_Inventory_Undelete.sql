CREATE PROCEDURE sp_Inventory_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE inventar SET is_deleted = false WHERE id = in_id;
END