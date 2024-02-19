CREATE PROCEDURE sp_PersonRole_Get ()
BEGIN
    SELECT * FROM person_rolle WHERE is_deleted = false;
END