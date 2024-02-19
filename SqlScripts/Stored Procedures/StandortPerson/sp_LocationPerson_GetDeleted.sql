CREATE PROCEDURE sp_LocationPerson_GetDeleted ()
BEGIN
    SELECT * FROM standort_person WHERE is_deleted = true;
END