CREATE PROCEDURE sp_PersonRole_GetDeleted ()
BEGIN
    SELECT * FROM person_role WHERE is_deleted = true;
END