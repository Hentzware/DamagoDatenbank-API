CREATE PROCEDURE sp_LocationPerson_Get ()
BEGIN
    SELECT * FROM location_person WHERE is_deleted = false;
END