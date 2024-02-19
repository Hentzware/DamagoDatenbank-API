CREATE PROCEDURE sp_Inventory_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM inventar WHERE id = in_id;
END