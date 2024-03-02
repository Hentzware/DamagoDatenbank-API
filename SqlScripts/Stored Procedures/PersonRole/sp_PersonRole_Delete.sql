CREATE PROCEDURE sp_PersonRole_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE person_role SET is_deleted = true WHERE id = in_id;
END