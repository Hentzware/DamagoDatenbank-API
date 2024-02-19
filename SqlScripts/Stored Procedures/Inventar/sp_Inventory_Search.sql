CREATE PROCEDURE sp_Inventory_Search (IN in_name VARCHAR(100), IN in_anzahl INT)
BEGIN
    SELECT * FROM inventar
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
      AND (anzahl = in_anzahl OR in_anzahl IS NULL);
END