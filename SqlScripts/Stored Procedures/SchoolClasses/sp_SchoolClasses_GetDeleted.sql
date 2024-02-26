CREATE PROCEDURE sp_SchoolClasses_GetDeleted ()
BEGIN
    SELECT * FROM school_classes WHERE is_deleted = true;
END