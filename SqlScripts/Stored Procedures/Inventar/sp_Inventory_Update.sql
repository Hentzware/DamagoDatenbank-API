CREATE PROCEDURE sp_Inventory_Update (IN in_id varchar(36), IN in_name varchar(100), IN in_anzahl int)
BEGIN
    UPDATE inventar
        SET
            name = IF (in_name IS NOT NULL, in_name, name),
            anzahl = IF (in_anzahl IS NOT NULL, in_anzahl, anzahl)
    WHERE id = in_id;
END