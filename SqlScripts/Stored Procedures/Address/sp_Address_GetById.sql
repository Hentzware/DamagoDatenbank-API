CREATE PROCEDURE sp_Address_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM address WHERE id = in_id;
END