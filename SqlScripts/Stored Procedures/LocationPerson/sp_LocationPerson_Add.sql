CREATE PROCEDURE sp_LocationPerson_Add (IN in_location_id VARCHAR(36), IN in_person_id VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO location_person (id, location_id, person_id, is_deleted)
    VALUES (out_id, in_location_id, in_person_id, false);
END