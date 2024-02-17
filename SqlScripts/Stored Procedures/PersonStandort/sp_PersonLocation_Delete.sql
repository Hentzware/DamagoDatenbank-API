CREATE PROCEDURE sp_PersonLocation_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE PersonStandort SET IsDeleted = true WHERE Id = in_id;
END