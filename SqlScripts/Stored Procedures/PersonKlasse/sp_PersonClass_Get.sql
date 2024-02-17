CREATE PROCEDURE sp_PersonClass_Get ()
BEGIN
    SELECT * FROM PersonKlasse WHERE IsDeleted = false;
END