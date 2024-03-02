CREATE PROCEDURE sp_Location_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM location WHERE id = in_id;
end;