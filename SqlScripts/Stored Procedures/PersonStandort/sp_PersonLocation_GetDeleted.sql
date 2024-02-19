CREATE PROCEDURE sp_PersonLocation_GetDeleted ()
BEGIN
    SELECT * FROM person_standort WHERE is_deleted = true;
END