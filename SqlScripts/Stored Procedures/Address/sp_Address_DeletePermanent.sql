CREATE PROCEDURE sp_Address_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM address WHERE id = in_id;
END