CREATE PROCEDURE sp_PersonClass_GetDeleted ()
BEGIN
    SELECT * FROM PersonKlasse WHERE IsDeleted = true;
END