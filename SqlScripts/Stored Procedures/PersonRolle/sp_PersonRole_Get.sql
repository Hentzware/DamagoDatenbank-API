CREATE PROCEDURE sp_PersonRole_Get ()
BEGIN
    SELECT * FROM person_role WHERE is_deleted = false;
END