CREATE PROCEDURE sp_PersonClass_GetDeleted ()
BEGIN
    SELECT * FROM person_klasse WHERE is_deleted = true;
END