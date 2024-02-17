CREATE PROCEDURE sp_Locations_Add (IN in_name VARCHAR(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO Standorte (Id, Name, IsDeleted)
    VALUES (out_id, in_name, false);
END