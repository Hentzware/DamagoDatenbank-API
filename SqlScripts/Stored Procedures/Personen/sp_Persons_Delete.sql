CREATE PROCEDURE sp_Persons_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE personen SET is_deleted = true WHERE id = in_id;
END