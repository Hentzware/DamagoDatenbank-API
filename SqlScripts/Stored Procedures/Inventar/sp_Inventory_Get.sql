CREATE PROCEDURE sp_Inventory_Get ()
BEGIN
    SELECT * FROM Inventar WHERE IsDeleted = false;
END