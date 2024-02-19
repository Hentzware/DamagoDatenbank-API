CREATE PROCEDURE sp_PersonLocation_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE person_standort SET is_deleted = true WHERE id = in_id;
END