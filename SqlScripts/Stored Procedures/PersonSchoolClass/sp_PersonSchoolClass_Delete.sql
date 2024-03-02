CREATE PROCEDURE sp_PersonSchoolClass_Delete (IN in_id VARCHAR(36))
BEGIN
   UPDATE person_school_class SET is_deleted = true WHERE id = in_id;
END