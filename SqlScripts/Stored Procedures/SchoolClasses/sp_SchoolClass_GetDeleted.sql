CREATE PROCEDURE sp_SchoolClass_GetDeleted ()
BEGIN
    SELECT * FROM school_class WHERE is_deleted = true;
END