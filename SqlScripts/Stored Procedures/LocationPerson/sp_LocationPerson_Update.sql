 CREATE PROCEDURE sp_LocationPerson_Update (IN in_id varchar(36), IN in_location_id varchar(36), IN in_person_id varchar(36))
 BEGIN
    UPDATE location_person
        SET
            location_id = IF (in_location_id IS NOT NULL, in_location_id, location_id),
            person_id = IF (in_person_id IS NOT NULL, in_person_id, person_id)
     WHERE Id = in_id;
 END