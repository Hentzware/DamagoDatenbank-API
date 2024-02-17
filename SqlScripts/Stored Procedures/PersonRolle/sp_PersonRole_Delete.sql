CREATE PROCEDURE sp_PersonRole_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE PersonRolle SET IsDeleted = true WHERE Id = in_id;
END