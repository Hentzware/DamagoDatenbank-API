CREATE PROCEDURE sp_PersonAdresse_Get ()
BEGIN
    SELECT * FROM PersonAdresse WHERE IsDeleted = false;
END