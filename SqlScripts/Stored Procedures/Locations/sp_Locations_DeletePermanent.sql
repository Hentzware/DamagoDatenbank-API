CREATE PROCEDURE sp_Locations_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM locations WHERE id = in_id;
END