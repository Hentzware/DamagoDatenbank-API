CREATE PROCEDURE sp_SchoolClasses_Get ()
BEGIN
    SELECT * FROM school_classes WHERE is_deleted = false;
END