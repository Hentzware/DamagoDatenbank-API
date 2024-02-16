CREATE PROCEDURE sp_Persons_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE Personen SET IsDeleted = true WHERE Id = in_id;
END