CREATE PROCEDURE sp_Adresses_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM adressen WHERE id = in_id;
END