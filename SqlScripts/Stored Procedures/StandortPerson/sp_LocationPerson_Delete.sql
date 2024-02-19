CREATE PROCEDURE sp_LocationPerson_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE standort_person SET is_deleted = true WHERE id = in_id;
END