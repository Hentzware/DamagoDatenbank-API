CREATE PROCEDURE sp_Addresses_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM addresses WHERE id = in_id;
END