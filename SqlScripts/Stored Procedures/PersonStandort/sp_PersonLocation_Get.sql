CREATE PROCEDURE sp_PersonLocation_Get ()
BEGIN
    SELECT * FROM PersonStandort WHERE IsDeleted = false;
END