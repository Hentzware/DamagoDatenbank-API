CREATE PROCEDURE sp_Phones_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE telefonnummern SET is_deleted = true WHERE id = in_id;
END