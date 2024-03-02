CREATE PROCEDURE sp_Inventory_Update (IN in_id varchar(36), IN in_name varchar(100), IN in_amount int)
BEGIN
    UPDATE inventory
        SET
            name = IF (in_name IS NOT NULL, in_name, name),
            amount = IF (in_amount IS NOT NULL, in_amount, amount)
    WHERE id = in_id;
END