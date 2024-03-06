CREATE PROCEDURE sp_ModuleSchoolClass_Get ()
BEGIN
    SELECT * FROM moduleSchoolClass WHERE is_deleted = false;
END