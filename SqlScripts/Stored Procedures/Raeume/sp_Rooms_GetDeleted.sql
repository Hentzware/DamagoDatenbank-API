CREATE PROCEDURE sp_Rooms_GetDeleted ()
BEGIN
    SELECT * FROM Raeume WHERE IsDeleted = true;
END