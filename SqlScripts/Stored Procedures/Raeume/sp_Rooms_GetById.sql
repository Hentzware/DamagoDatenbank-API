CREATE PROCEDURE sp_Rooms_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM raeume WHERE id = in_id;
end;