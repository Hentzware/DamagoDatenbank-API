CREATE PROCEDURE sp_PersonClass_Get ()
BEGIN
    SELECT * FROM person_klasse WHERE is_deleted = false;
END