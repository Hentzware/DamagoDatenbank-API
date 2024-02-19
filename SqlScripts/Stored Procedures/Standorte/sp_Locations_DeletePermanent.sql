CREATE PROCEDURE sp_Locations_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM standorte WHERE id = in_id;
END