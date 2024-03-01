CREATE PROCEDURE sp_Addresses_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM addresses WHERE id = in_id;
END