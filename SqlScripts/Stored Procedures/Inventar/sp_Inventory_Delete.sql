CREATE PROCEDURE sp_Inventory_Delete (IN in_id varchar(36))
BEGIN
    UPDATE Inventar SET IsDeleted = true WHERE Id = in_id;
END