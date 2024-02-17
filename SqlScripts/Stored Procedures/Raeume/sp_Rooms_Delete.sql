CREATE PROCEDURE sp_Rooms_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE Raeume SET IsDeleted = true WHERE Id = in_id;
END