CREATE PROCEDURE sp_Locations_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE Standorte SET IsDeleted = true WHERE Id = in_id;
END