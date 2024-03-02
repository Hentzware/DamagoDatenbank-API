CREATE PROCEDURE sp_PersonSchoolClass_GetDeleted ()
BEGIN
    SELECT * FROM person_school_class WHERE is_deleted = true;
END