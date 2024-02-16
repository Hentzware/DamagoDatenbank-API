CREATE PROCEDURE sp_Inventory_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM Inventar WHERE Id = in_id;
END