CREATE PROCEDURE sp_ModulePerson_GetDeleted ()
BEGIN
    SELECT * FROM modulePerson WHERE is_deleted = true;
END