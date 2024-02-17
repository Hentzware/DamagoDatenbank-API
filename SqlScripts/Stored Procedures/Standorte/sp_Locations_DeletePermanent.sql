CREATE PROCEDURE sp_Locations_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM Standorte WHERE Id = in_id;
END