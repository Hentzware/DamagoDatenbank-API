CREATE PROCEDURE sp_Role_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE role SET is_deleted = true WHERE id = in_id;
END