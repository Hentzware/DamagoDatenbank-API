CREATE PROCEDURE sp_PersonRole_GetDeleted ()
BEGIN
    SELECT * FROM person_rolle WHERE is_deleted = true;
END