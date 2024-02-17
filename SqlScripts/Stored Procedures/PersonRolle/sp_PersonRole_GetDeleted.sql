CREATE PROCEDURE sp_PersonRole_GetDeleted ()
BEGIN
    SELECT * FROM PersonRolle WHERE IsDeleted = true;
END