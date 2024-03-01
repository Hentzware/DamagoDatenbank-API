CREATE PROCEDURE sp_LocationPerson_Search (IN in_location_id VARCHAR(36), IN in_person_id VARCHAR(36))
BEGIN
    SELECT * FROM location_person
        WHERE (location_id = in_location_id OR in_location_id IS NULL)
          AND (person_id = in_person_id OR in_person_id IS NULL);
END