CREATE PROCEDURE sp_LocationSchoolClass_GetDeleted ()
BEGIN
    SELECT * FROM locationSchoolClass WHERE is_deleted = true;
END