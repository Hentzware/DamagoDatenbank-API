CREATE PROCEDURE sp_PersonLocation_GetDeleted ()
BEGIN
    SELECT * FROM PersonStandort WHERE IsDeleted = true;
END