CREATE PROCEDURE sp_ModulePerson_Get ()
BEGIN
    SELECT * FROM modulePerson WHERE is_deleted = false;
END