CREATE PROCEDURE sp_LocationPerson_GetDeleted ()
BEGIN
    SELECT * FROM location_person WHERE is_deleted = true;
END