CREATE PROCEDURE sp_Inventory_Add (IN in_name varchar(100), IN in_anzahl varchar(100), OUT out_id VARCHAR(36))
BEGIN
    DECLARE out_id VARCHAR(36);
    SET out_id = UUID();
    INSERT INTO Inventar (Id, Name, Anzahl, IsDeleted)
        VALUES (out_id, in_name, in_anzahl, false);
END