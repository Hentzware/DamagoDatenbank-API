CREATE PROCEDURE sp_Phones_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE Telefonnummern SET IsDeleted = true WHERE Id = in_id;
END