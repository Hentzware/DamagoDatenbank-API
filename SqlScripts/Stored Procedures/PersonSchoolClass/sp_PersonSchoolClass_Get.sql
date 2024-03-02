CREATE PROCEDURE sp_PersonSchoolClass_Get ()
BEGIN
    SELECT * FROM person_school_class WHERE is_deleted = false;
END