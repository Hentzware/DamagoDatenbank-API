CREATE PROCEDURE sp_Inventory_Add (IN in_name varchar(100), IN in_anzahl varchar(100))
BEGIN
    INSERT INTO Inventar (Id, Name, Anzahl, IsDeleted)
        VALUES (UUID(), in_name, in_anzahl, false);
END