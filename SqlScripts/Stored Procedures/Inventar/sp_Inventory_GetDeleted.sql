CREATE PROCEDURE sp_Inventory_GetDeleted()
BEGIN
    SELECT * FROM Inventar WHERE IsDeleted = true;
END