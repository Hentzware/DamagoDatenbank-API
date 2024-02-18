CREATE PROCEDURE sp_Classes_Add (IN in_name varchar(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO Klassen (Id, Name, IsDeleted)
        VALUES (out_id, in_name, false);
END