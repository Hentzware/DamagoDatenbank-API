CREATE PROCEDURE sp_Inventory_GetById (IN in_id varchar(36))
BEGIN
    SELECT * FROM inventar WHERE id = in_id;
END