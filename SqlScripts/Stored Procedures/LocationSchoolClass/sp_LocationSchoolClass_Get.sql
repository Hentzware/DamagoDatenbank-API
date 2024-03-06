CREATE PROCEDURE sp_LocationSchoolClass_Get ()
BEGIN
    SELECT * FROM locationSchoolClass WHERE is_deleted = false;
END