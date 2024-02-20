CREATE PROCEDURE sp_LocationPerson_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM standort_person WHERE id = in_id;
end;