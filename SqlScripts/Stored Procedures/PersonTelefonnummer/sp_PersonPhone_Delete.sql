CREATE PROCEDURE sp_PersonPhone_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE PersonTelefonnummer SET IsDeleted = true WHERE Id = in_id;
END