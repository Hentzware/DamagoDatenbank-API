CREATE PROCEDURE sp_Inventory_Add (IN in_name varchar(100), IN in_anzahl varchar(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO inventar (id, name, anzahl, is_deleted)
        VALUES (out_id, in_name, in_anzahl, false);
END