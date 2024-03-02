CREATE PROCEDURE sp_Inventory_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM inventory WHERE id = in_id;
END