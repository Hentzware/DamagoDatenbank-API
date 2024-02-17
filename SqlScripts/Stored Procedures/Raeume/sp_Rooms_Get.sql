CREATE PROCEDURE sp_Rooms_Get ()
BEGIN
    SELECT * FROM Raeume WHERE IsDeleted = false;
END