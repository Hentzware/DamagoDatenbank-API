CREATE PROCEDURE sp_PersonAdress_Get ()
BEGIN
    SELECT * FROM PersonAdresse WHERE IsDeleted = false;
END