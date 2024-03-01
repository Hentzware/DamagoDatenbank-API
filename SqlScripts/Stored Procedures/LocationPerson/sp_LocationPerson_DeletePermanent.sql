CREATE PROCEDURE sp_LocationPerson_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM location_person WHERE id = in_id;
END