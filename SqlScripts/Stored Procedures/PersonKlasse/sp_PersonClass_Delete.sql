CREATE PROCEDURE sp_PersonClass_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE PersonKlasse SET IsDeleted = true WHERE Id = in_id;
END