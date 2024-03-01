CREATE PROCEDURE sp_Inventories_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM inventories WHERE id = in_id;
END