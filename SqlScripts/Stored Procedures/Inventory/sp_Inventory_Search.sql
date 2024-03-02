CREATE PROCEDURE sp_Inventory_Search (IN in_name VARCHAR(100), IN in_amount INT)
BEGIN
    SELECT * FROM inventory
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
      AND (amount = in_amount OR in_amount IS NULL);
END