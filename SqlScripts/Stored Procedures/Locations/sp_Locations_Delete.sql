CREATE PROCEDURE sp_Locations_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE locations SET is_deleted = true WHERE id = in_id;
END