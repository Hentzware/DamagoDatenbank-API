CREATE PROCEDURE sp_PersonRole_Get ()
BEGIN
    SELECT * FROM PersonRolle WHERE IsDeleted = false;
END