CREATE PROCEDURE sp_SchoolClass_Get ()
BEGIN
    SELECT * FROM school_class WHERE is_deleted = false;
END