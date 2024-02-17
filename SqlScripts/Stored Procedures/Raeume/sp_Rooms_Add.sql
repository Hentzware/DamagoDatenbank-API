CREATE PROCEDURE sp_Rooms_Add (IN in_name VARCHAR(100), IN in_nr VARCHAR(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO Raeume (Id, Name, Nr, IsDeleted)
    VALUES (out_id, in_name, in_nr, false);
END