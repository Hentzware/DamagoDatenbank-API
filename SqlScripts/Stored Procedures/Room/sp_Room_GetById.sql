CREATE PROCEDURE sp_Room_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM room WHERE id = in_id;
end;