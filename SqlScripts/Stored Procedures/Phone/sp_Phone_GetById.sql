CREATE PROCEDURE sp_Phone_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM phone WHERE id = in_id;
end;