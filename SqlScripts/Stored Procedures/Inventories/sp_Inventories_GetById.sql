CREATE PROCEDURE sp_Inventories_GetById (IN in_id varchar(36))
BEGIN
    SELECT * FROM inventories WHERE id = in_id;
END