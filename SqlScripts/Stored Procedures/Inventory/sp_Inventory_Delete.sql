CREATE PROCEDURE sp_Inventory_Delete (IN in_id varchar(36))
BEGIN
    UPDATE inventory SET is_deleted = true WHERE id = in_id;
END