CREATE PROCEDURE sp_PersonLocation_Get ()
BEGIN
    SELECT * FROM person_standort WHERE is_deleted = false;
END