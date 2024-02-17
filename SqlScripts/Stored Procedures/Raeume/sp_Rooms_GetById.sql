CREATE PROCEDURE sp_Rooms_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM Raeume WHERE Id = in_id;
end;