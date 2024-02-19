CREATE PROCEDURE sp_LocationPerson_Get ()
BEGIN
    SELECT * FROM standort_person WHERE is_deleted = false;
END