CREATE PROCEDURE sp_Adresses_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM adressen WHERE id = in_id;
END