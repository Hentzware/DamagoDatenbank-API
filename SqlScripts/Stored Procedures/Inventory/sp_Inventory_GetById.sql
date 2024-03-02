CREATE PROCEDURE sp_Inventory_GetById (IN in_id varchar(36))
BEGIN
    SELECT * FROM inventory WHERE id = in_id;
END