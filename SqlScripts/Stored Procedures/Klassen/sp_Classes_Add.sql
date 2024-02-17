CREATE PROCEDURE sp_Classes_Add (IN in_name varchar(100), IN in_nr varchar(100), OUT out_id VARCHAR(36))
BEGIN
    DECLARE out_id VARCHAR(36);
    SET out_id = UUID();
    INSERT INTO Klassen (Id, Name, Nr, IsDeleted)
        VALUES (out_id, in_name, in_nr, false);
END