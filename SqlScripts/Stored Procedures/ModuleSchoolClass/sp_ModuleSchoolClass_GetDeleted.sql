CREATE PROCEDURE sp_ModuleSchoolClass_GetDeleted ()
BEGIN
    SELECT * FROM moduleSchoolClass WHERE is_deleted = true;
END